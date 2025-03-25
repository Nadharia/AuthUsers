package com.example.AuthUsers.Services;

import com.example.AuthUsers.Models.Alumno;
import com.example.AuthUsers.Repository.AlumnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AdminService {

    @Autowired
    private AlumnoRepository alumnoRepository;
    public List<Alumno> obtenerAlumnos(){
        try{
            return alumnoRepository.findAll();
        }catch(Exception e){
            throw new RuntimeException("Error al obtener los usuarios",e);
        }

    }
}
