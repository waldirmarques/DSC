package br.com.laboratorio03.diciplina.service;

import br.com.laboratorio03.diciplina.Disciplina;
import br.com.laboratorio03.diciplina.DisciplinaRepository;
import br.com.laboratorio03.diciplina.exception.DisciplinaFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetDisciplinaServiceImpl implements GetDisciplinaService {
    private final DisciplinaRepository disciplinaRepository;

    @Override
    public Disciplina findById(Long id) {
        return disciplinaRepository.findById(id).orElseThrow(DisciplinaFoundException::new);
    }
}
