package br.com.laboratorio02.diciplina.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class DisciplinaFoundException extends RuntimeException {

    public DisciplinaFoundException() {
        super("Disciplina não encontrada !");
    }
}
