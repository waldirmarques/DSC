package br.com.laboratorio02.diciplina.service;

import br.com.laboratorio02.diciplina.Disciplina;

import java.util.List;

@FunctionalInterface
public interface GetAllDisciplinaService {
    List<Disciplina> findAll();
}
