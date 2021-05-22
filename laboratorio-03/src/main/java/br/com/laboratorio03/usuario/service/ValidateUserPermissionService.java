package br.com.laboratorio03.usuario.service;

@FunctionalInterface
public interface ValidateUserPermissionService {
    boolean userHasPermission(String authHeader, String email);
}
