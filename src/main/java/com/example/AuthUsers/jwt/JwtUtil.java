package com.example.AuthUsers.jwt;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;


import javax.crypto.SecretKey;
import java.security.Key;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Component
public class JwtUtil {

    private static final Key secretkey = Keys.hmacShaKeyFor("una_clave_secreta_que_tiene_al_menos_256_bits_de_largo".getBytes());
    Date expirationDate = new Date(System.currentTimeMillis() + 36000000);

    public String generarToken(String username, List<String> roles) {


        return Jwts.builder().subject(username).claim("roles", roles).expiration(expirationDate).signWith(secretkey).compact();
    }


    Claims obtenerClaims(String token) {
        try {

            return Jwts.parser().verifyWith((SecretKey) secretkey).build().parseSignedClaims(token).getPayload();
        } catch (ClaimJwtException e) {
            throw new RuntimeException("Token mal formado");
        }
    }

    public ResponseEntity<String> validarToken(String token) {
        Claims claim = obtenerClaims(token);
        try {
            if (claim.getExpiration() != null && claim.getExpiration().after(new Date())) {
                return ResponseEntity.ok("token valido");
            } else {

                String rolesString = claim.get("roles", String.class);
                List<String> roles = Arrays.asList(rolesString.split(","));
                String newToken = refreshToken(claim.getSubject(), roles);
                return ResponseEntity.ok(newToken);

            }
        } catch (ClaimJwtException e) {
            return ResponseEntity.badRequest().body("Mal claimeado");
        }


    }


    public String obtenerUsername(String token) {
        try {
            Claims claim = obtenerClaims(token);
            return claim.getSubject();
        } catch (ClaimJwtException e) {
            return ("token mal formado");
        }


    }

    public String refreshToken(String username, List<String> roles) {

        return Jwts.builder().subject(username).claim("roles", String.join(",", roles)).expiration(expirationDate).signWith(secretkey).compact();

    }


}
