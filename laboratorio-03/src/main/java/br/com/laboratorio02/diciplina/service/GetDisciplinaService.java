package br.com.laboratorio02.diciplina.service;

import br.com.laboratorio02.diciplina.Disciplina;

@FunctionalInterface
public interface GetDisciplinaService {
    Disciplina findById(Long id);
}
