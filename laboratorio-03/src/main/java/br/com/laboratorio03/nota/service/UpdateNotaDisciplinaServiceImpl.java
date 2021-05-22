package br.com.laboratorio03.nota.service;

import br.com.laboratorio03.diciplina.Disciplina;
import br.com.laboratorio03.diciplina.DisciplinaDTO;
import br.com.laboratorio03.diciplina.DisciplinaRepository;
import br.com.laboratorio03.nota.Nota;
import br.com.laboratorio03.nota.NotaRepository;
import br.com.laboratorio03.diciplina.exception.DisciplinaFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UpdateNotaDisciplinaServiceImpl implements UpdateNotaDisciplinaService {
    private final DisciplinaRepository disciplinaRepository;
    private final NotaRepository notaRepository;

    @Override
    public Disciplina updateNota(Long id, DisciplinaDTO disciplinaDTO) {
        var disciplina = disciplinaRepository.findById(id)
                .orElseThrow(DisciplinaFoundException::new);

        List<Nota> notas = disciplina.getNotas();
        if (notas.isEmpty()) {
            var nota = Nota.builder().media(disciplinaDTO.getNota()).build();
            notas.add(nota);
            disciplina.setMediaAritmetica(nota.getMedia());
        } else {
            notas.add(Nota.builder().media(disciplinaDTO.getNota()).build());
            Double soma = 0.0;
            for (Nota nota : notas) {
                soma += nota.getMedia();
            }
            var media = soma / notas.size();
            disciplina.setMediaAritmetica(media);
        }
        notaRepository.saveAll(notas);
        return disciplinaRepository.save(disciplina);
    }
}
