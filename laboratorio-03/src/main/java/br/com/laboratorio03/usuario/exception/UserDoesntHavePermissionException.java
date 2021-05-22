package br.com.laboratorio03.usuario.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UserDoesntHavePermissionException extends RuntimeException {

    private static final long serialVersionUID = -8043187798854153530L;

    public UserDoesntHavePermissionException(){
        super("Usuario nao tem permissao.");
    }

}
