package br.com.laboratorio02.diciplina.service;

import br.com.laboratorio02.diciplina.Disciplina;
import br.com.laboratorio02.diciplina.DisciplinaDTO;

public interface UpdateNotaDisciplinaService {
    Disciplina updateNota(Long id, DisciplinaDTO disciplinaDTO);
}
