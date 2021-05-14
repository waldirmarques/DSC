package br.com.laboratorio02.diciplina.service;

import br.com.laboratorio02.diciplina.Disciplina;
import br.com.laboratorio02.diciplina.DisciplinaDTO;

public interface CreateComentarioDisciplinaService {
    Disciplina createComentario(Long id, DisciplinaDTO disciplinaDTO);
}
