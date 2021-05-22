package br.com.laboratorio03.diciplina.service;

import br.com.laboratorio03.diciplina.Disciplina;
import br.com.laboratorio03.diciplina.DisciplinaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetListOrderNotasDisciplinaServiceImpl implements GetListOrderNotasDisciplinaService{
    private final DisciplinaRepository disciplinaRepository;

    @Override
    public List<Disciplina> sortNotaDisciplinas() {
        return disciplinaRepository.findAll();
    }
}
