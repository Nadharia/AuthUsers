package com.example.AuthUsers.Repository;

import com.example.AuthUsers.Models.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AlumnoRepository extends JpaRepository<Alumno,Long> {


    Optional<Alumno> findByUsername(String username);
}
