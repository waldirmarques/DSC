package br.com.laboratorio02.diciplina.service;

import br.com.laboratorio02.diciplina.Disciplina;
import br.com.laboratorio02.diciplina.DisciplinaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetAllDisciplinaServiceImpl implements GetAllDisciplinaService{
    private final DisciplinaRepository disciplinaRepository;

    @Override
    public List<Disciplina> findAll() {
        return disciplinaRepository.findAll();
    }
}
