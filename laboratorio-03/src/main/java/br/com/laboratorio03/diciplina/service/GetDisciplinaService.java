package br.com.laboratorio03.diciplina.service;

import br.com.laboratorio03.diciplina.Disciplina;

@FunctionalInterface
public interface GetDisciplinaService {
    Disciplina findById(Long id);
}
