package com.example.AuthUsers.Services;


import com.example.AuthUsers.Models.LoginDTO;
import com.example.AuthUsers.Repository.AlumnoRepository;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;




@Service
public class AuthService {

    private final AlumnoRepository alumnoRepository;
    private final SeccionService seccionService;
    private final PasswordEncoder passwordEncoder;

    public AuthService(AlumnoRepository alumnoRepository, SeccionService seccionService, PasswordEncoder passwordEncoder) {
        this.alumnoRepository = alumnoRepository;
        this.seccionService = seccionService;
        this.passwordEncoder = passwordEncoder;
    }

    public ResponseEntity<String> login(LoginDTO loginDTO, HttpServletRequest request){
        return alumnoRepository.findByUsername(loginDTO.getUsername())
                .filter(alumno -> passwordEncoder.matches(loginDTO.getPassword(), alumno.getPassword()))
                .map(alumno -> {
                    seccionService.createSeccion(request);
                    return ResponseEntity.ok("Seccion creada con éxito");
                })
                .orElseGet(()->ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales incorrectas"));

    }
}