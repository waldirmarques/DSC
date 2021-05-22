package br.com.laboratorio03.usuario.service;

import br.com.laboratorio03.usuario.UsuarioLoginDTO;
import br.com.laboratorio03.usuario.UsuarioRepository;
import br.com.laboratorio03.usuario.exception.UsuarioNotFoundException;
import br.com.laboratorio03.jwt.JWTService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginUsuarioServiceImpl implements LoginUsuarioService{

    private final UsuarioRepository usuarioRepository;
    private final JWTService jwtService;

    @Override
    public String loginUsuario(UsuarioLoginDTO usuarioLoginDTO) {
        var usuario = usuarioRepository.findAllByEmail(usuarioLoginDTO.getEmail())
                .orElseThrow(UsuarioNotFoundException::new);

        if (usuario.getSenha().equals(usuarioLoginDTO.getSenha())) {
            return jwtService.generateToken(usuario.getNome());
        }
        return "Senha incorreta";
    }
}
