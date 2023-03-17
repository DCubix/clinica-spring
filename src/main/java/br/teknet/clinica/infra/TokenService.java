package br.teknet.clinica.infra;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;

import br.teknet.clinica.model.Usuario;

@Service
public class TokenService {
    
    @Value("${api.security.token.secret}")
    private String secret;

    public String gerarToken(Usuario usuario) {
        try {
            var algoritmo = Algorithm.HMAC256(secret);
            return JWT.create()
                .withIssuer("api-clinica")
                .withSubject(usuario.getLogin())
                .withExpiresAt(Instant.now().plus(2, ChronoUnit.HOURS))
                .withClaim("id", usuario.getId())
                .sign(algoritmo);
        } catch (JWTCreationException exception) {
            throw new RuntimeException("falha ao gerar o token", exception);
        }
    }

    public String getSubject(String tokenJWT) {
        try {
            var algoritmo = Algorithm.HMAC256(secret);
            return JWT.require(algoritmo)
                // specify an specific claim validations
                .withIssuer("api-clinica")
                // reusable verifier instance
                .build()
                .verify(tokenJWT)
                .getSubject();
        } catch (JWTVerificationException exception){
            throw new RuntimeException("token inválido ou expirado", exception);
        }
    }

}
