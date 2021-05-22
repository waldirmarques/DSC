package br.com.laboratorio03.usuario.service;

import br.com.laboratorio03.usuario.UsuarioLoginDTO;

@FunctionalInterface
public interface LoginUsuarioService {
    String loginUsuario(UsuarioLoginDTO usuario);
}
