package com.example.AuthUsers.Controllers;

import com.example.AuthUsers.Models.Alumno;
import com.example.AuthUsers.Services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/hola")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping
    public List<Alumno> obtenerAlumnos(String token){
        return adminService.obtenerAlumnos();
    }


    @DeleteMapping
    public void eliminarAlumno(String token){}
}
