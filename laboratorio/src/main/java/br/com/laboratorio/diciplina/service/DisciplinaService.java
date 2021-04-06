package br.com.laboratorio.diciplina.service;


import br.com.laboratorio.diciplina.Disciplina;
import br.com.laboratorio.diciplina.DisciplinaDTO;

import java.util.List;

public interface DisciplinaService {

    void save(Disciplina disciplina);

    List<Disciplina> findAll();

    Disciplina findById(int id);

    Disciplina updateName(int id, DisciplinaDTO disciplinaDTO);

    Disciplina updateNota(int id, DisciplinaDTO disciplinaDTO);

    void remove(int id);

    List<Disciplina> sortNotaDisciplinas();
}
