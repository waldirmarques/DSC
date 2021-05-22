package br.com.laboratorio03.usuario;

import br.com.laboratorio03.usuario.service.CriarUsuarioService;
import br.com.laboratorio03.usuario.service.DeleteUserService;
import br.com.laboratorio03.usuario.service.LoginUsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api")
public class UsuarioController {

    private final CriarUsuarioService criarUsuarioService;
    private final LoginUsuarioService loginUsuarioService;
    private final DeleteUserService deleteUserService;

    @PostMapping(value ="/usuarios", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        criarUsuarioService.createUsuario(Usuario.from(usuarioDTO));
    }

    @PostMapping(value ="/login", produces = MediaType.APPLICATION_JSON_VALUE)
    public String loginUsuario(@RequestBody UsuarioLoginDTO usuarioLoginDTO) {
        return loginUsuarioService.loginUsuario(usuarioLoginDTO);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping(value = "/usuarios/{email}")
    public void delete(@PathVariable String email, @RequestHeader("Authorization") String header){
        this.deleteUserService.delete(email, header);
    }



}
