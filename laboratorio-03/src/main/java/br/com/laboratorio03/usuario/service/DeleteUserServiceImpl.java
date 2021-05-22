package br.com.laboratorio03.usuario.service;

import br.com.laboratorio03.usuario.UsuarioRepository;
import br.com.laboratorio03.usuario.exception.UserDoesntHavePermissionException;
import br.com.laboratorio03.usuario.exception.UsuarioNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class DeleteUserServiceImpl implements DeleteUserService {
    private final UsuarioRepository usuarioRepository;
    private final ValidateUserPermissionService validateUserPermissionService;

    @Override
    public void delete(String email, String authHeader) {
        var usuario = this.usuarioRepository.findByEmail(email)
                .orElseThrow(UsuarioNotFoundException::new);

        if (this.validateUserPermissionService.userHasPermission(authHeader, email)) {
            usuarioRepository.delete(usuario);
        }
        throw new UserDoesntHavePermissionException();
    }
}
