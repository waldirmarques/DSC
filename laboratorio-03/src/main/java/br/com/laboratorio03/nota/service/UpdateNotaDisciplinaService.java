package br.com.laboratorio03.nota.service;

import br.com.laboratorio03.diciplina.Disciplina;
import br.com.laboratorio03.diciplina.DisciplinaDTO;

public interface UpdateNotaDisciplinaService {
    Disciplina updateNota(Long id, DisciplinaDTO disciplinaDTO);
}
