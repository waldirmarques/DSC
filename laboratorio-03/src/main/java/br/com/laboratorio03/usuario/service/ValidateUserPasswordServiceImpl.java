package br.com.laboratorio03.usuario.service;

import br.com.laboratorio03.usuario.Usuario;
import br.com.laboratorio03.usuario.UsuarioRepository;
import br.com.laboratorio03.usuario.exception.UsuarioNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ValidateUserPasswordServiceImpl implements ValidateUserPasswordService {

    private final UsuarioRepository userRepository;

    @Override
    public boolean validateUserPassword(Usuario user) {
        var foundUser = this.userRepository.findByEmail(user.getEmail()).orElseThrow(UsuarioNotFoundException::new);
        return foundUser.getSenha().equals(user.getSenha());
    }

}
