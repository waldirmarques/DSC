package br.com.laboratorio03.jwt.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class InvalidTokenException extends RuntimeException {

    private static final long serialVersionUID = -8043187798854153530L;

    public InvalidTokenException(){
        super("Não autenticado.");
    }

    public InvalidTokenException(String msg){
        super(msg);
    }

}
