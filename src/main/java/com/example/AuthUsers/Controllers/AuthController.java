package com.example.AuthUsers.Controllers;


import com.example.AuthUsers.Models.Alumno;
import com.example.AuthUsers.Models.LoginDTO;
import com.example.AuthUsers.Services.AuthService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/hola")

public class AuthController {



    private final AuthService authService;

    public AuthController( AuthService authService) {

        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(){
    return null;
    }

    @GetMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody LoginDTO loginDTO, HttpServletRequest request){
        return authService.login(loginDTO,request);

    }

    @PostMapping("/home")
    public String home(){
        return null;
    }
}
