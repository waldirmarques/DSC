package br.com.laboratorio03.usuario.service;

@FunctionalInterface
public interface DeleteUserService {
    void delete(String email, String header);
}
