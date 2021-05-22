package br.com.laboratorio03.usuario.service;

import br.com.laboratorio03.usuario.Usuario;

@FunctionalInterface
public interface CriarUsuarioService {
    void createUsuario(Usuario usuario);
}
