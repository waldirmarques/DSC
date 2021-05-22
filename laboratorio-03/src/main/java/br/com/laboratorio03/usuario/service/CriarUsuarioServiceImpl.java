package br.com.laboratorio03.usuario.service;

import br.com.laboratorio03.usuario.Usuario;
import br.com.laboratorio03.usuario.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CriarUsuarioServiceImpl implements CriarUsuarioService {

    private final UsuarioRepository usuarioRepository;

    @Override
    public void createUsuario(Usuario usuario) {
        usuarioRepository.save(usuario);
    }
}
