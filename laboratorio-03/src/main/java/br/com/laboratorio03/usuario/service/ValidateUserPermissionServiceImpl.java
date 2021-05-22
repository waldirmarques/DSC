package br.com.laboratorio03.usuario.service;

import br.com.laboratorio03.jwt.JWTService;
import br.com.laboratorio03.usuario.Usuario;
import br.com.laboratorio03.usuario.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ValidateUserPermissionServiceImpl implements ValidateUserPermissionService {
    private UsuarioRepository userRepository;
    private final JWTService jwtService;

    @Override
    public boolean userHasPermission(String authorizationHeader, String email) {
        String subject = jwtService.getSujeitoDoToken(authorizationHeader);
        Optional<Usuario> optUsuario = userRepository.findByEmail(subject);
        return optUsuario.isPresent() && optUsuario.get().getEmail().equals(email);
    }
}
