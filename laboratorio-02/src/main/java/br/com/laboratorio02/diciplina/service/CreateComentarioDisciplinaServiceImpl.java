package br.com.laboratorio02.diciplina.service;

import br.com.laboratorio02.diciplina.Comentario;
import br.com.laboratorio02.diciplina.Disciplina;
import br.com.laboratorio02.diciplina.DisciplinaDTO;
import br.com.laboratorio02.diciplina.DisciplinaRepository;
import br.com.laboratorio02.diciplina.exception.DisciplinaFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class CreateComentarioDisciplinaServiceImpl implements CreateComentarioDisciplinaService {
    private final DisciplinaRepository disciplinaRepository;

    @Override
    public Disciplina createComentario(Long id, DisciplinaDTO disciplinaDTO) {
        var disciplina = disciplinaRepository.findById(id)
                .orElseThrow(DisciplinaFoundException::new);

        var comentario = Comentario.builder()
                .descricao(disciplinaDTO.getComentario())
                .build();

        List<Comentario> comentarios = new ArrayList<>();
        comentarios.add(comentario);
        disciplina.setComentarios(comentarios);
        return disciplinaRepository.save(disciplina);
    }
}
