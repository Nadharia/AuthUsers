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
@RequestMapping("/")
@RequiredArgsConstructor
public class AuthController {


    private final LoginDTO loginDTO;
    private final AuthService authService;



    @PostMapping("/register")
    public ResponseEntity<String> registerUser(){

    }

    @GetMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody LoginDTO loginDTO, HttpServletRequest request){
        return authService.login(loginDTO,request);

    }
}
