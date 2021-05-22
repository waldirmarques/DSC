package br.com.laboratorio03.diciplina.service;

import br.com.laboratorio03.diciplina.Disciplina;

import java.util.List;

@FunctionalInterface
public interface GetAllDisciplinaService {
    List<Disciplina> findAll();
}
