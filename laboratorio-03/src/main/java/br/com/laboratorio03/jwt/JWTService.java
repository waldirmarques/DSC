package br.com.laboratorio03.jwt;

import br.com.laboratorio03.jwt.exception.InvalidTokenException;
import br.com.laboratorio03.usuario.Usuario;
import br.com.laboratorio03.usuario.service.ValidateUserPasswordService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@Getter
@RequiredArgsConstructor
public class JWTService {

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private Long expiration;

    private final ValidateUserPasswordService validateUserPasswordService;

    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username) //Usuario
                .setExpiration(new Date(System.currentTimeMillis() + expiration)) //Tempo de inspiração
                .signWith(SignatureAlgorithm.HS512, secret.getBytes()) //Algoritmo que acina o token
                .compact();
    }

    public boolean tokenValido(String token) {
        var claims = getClaims(token);
        if (claims != null) {
            String username = claims.getSubject();
            var expirationDate = claims.getExpiration();
            var now = new Date(System.currentTimeMillis());
            return username != null && expirationDate != null && now.before(expirationDate);
        }
        return false;
    }

    public String getUsername(String token) {
        var claims = getClaims(token);
        if (claims != null) {
            return claims.getSubject();
        }
        return null;
    }

    private Claims getClaims(String token) {
        try {
            return Jwts.parser().setSigningKey(secret.getBytes()).parseClaimsJws(token).getBody();
        } catch (Exception e) {
            return null;
        }
    }

    public String getSujeitoDoToken(String authorizationHeader) {
        if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")) {
            throw new InvalidTokenException("Token inexistente ou mal formatado!");
        }

        // Extraindo apenas o token do cabecalho.
        var token = authorizationHeader.substring(JWTFilter.TOKEN_INDEX);

        String subject;
        try {
            subject = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getSubject();
        } catch (SignatureException e) {
            throw new SecurityException("Token invalido ou expirado!");
        }
        return subject;
    }

    public LoginResponse autentica(Usuario usuario) {

        if (!validateUserPasswordService.validateUserPassword(usuario)) {
            return new LoginResponse("Usuario ou senha invalidos. Nao foi realizado o login.");
        }

        String token = generateToken(usuario.getEmail());
        return new LoginResponse(token);
    }


}

