package com.example.AuthUsers.jwt;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;


import java.security.Key;
import java.util.Date;
import java.util.List;

public class JwtUtil {

    private static final Key key= Keys.hmacShaKeyFor("mi_clave_secreta".getBytes());
    Date expirationDate=new Date(System.currentTimeMillis()+36000000);

    public String generarToken(String username, List<String> roles){


        return Jwts.builder()
                .subject(username)
                .claim("roles",roles)
                .expiration(expirationDate)
                .signWith(key)
                .compact();
    }
}
