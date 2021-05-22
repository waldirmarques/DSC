package br.com.laboratorio03.diciplina.service;

import br.com.laboratorio03.diciplina.Disciplina;
import br.com.laboratorio03.diciplina.DisciplinaRepository;
import br.com.laboratorio03.diciplina.exception.DisciplinaFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdateLikeDisciplinaServiceImpl implements UpdateLikeDisciplinaService {
    private final DisciplinaRepository disciplinaRepository;

    @Override
    public Disciplina updateLike(Long id) {
        var disciplina = disciplinaRepository.findById(id)
                .orElseThrow(DisciplinaFoundException::new);
        disciplina.setCurtidas(disciplina.getCurtidas() == null ? 1 : disciplina.getCurtidas() + 1);
        return disciplinaRepository.save(disciplina);
    }
}
