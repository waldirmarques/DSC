package br.com.laboratorio03.usuario.service;

import br.com.laboratorio03.usuario.Usuario;

@FunctionalInterface
public interface ValidateUserPasswordService {

    boolean validateUserPassword(Usuario user);

}
