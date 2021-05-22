package br.com.laboratorio03.comentario.service;

import br.com.laboratorio03.diciplina.Disciplina;
import br.com.laboratorio03.diciplina.DisciplinaDTO;

public interface CreateComentarioDisciplinaService {
    Disciplina createComentario(Long id, DisciplinaDTO disciplinaDTO);
}
