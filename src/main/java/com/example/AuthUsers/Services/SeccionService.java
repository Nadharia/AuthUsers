package com.example.AuthUsers.Services;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
@Slf4j
@Service
public class SeccionService {

    public ResponseEntity<String> checkSeccion(HttpServletRequest request){
        if (request.getSession(false)!= null) {
            System.out.println("Usuario autenticado");
            return ResponseEntity.ok("Usuario autenticado");
        }else{
            System.out.println("Intento de acceso sin sesión activa");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("No autorizado");
        }
    }

    public ResponseEntity<String> logout(HttpServletRequest request){
        request.getSession().invalidate();
        return ResponseEntity.ok("Seccion cerrada con exito");
    }

    public ResponseEntity<String> createSeccion(HttpServletRequest request){
        if (request.getSession(false)!=null) {
            System.out.println("seccion creada:createSeccion");
            return ResponseEntity.ok("Seccion creada");
        }else{
            System.out.println("Problemas al crear seccion:createSeccion");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Seccion no creada");
        }

    }
}
