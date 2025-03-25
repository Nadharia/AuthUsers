package com.example.AuthUsers.Security;

import com.example.AuthUsers.Repository.AlumnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsServiceImpl implements UserDetailsService {


    private final AlumnoRepository alumnoRepository;

    public UserDetailsServiceImpl(AlumnoRepository alumnoRepository) {
        this.alumnoRepository = alumnoRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return alumnoRepository.findByUsername(username)
                .orElseThrow(()->new UsernameNotFoundException("Usuarion no encontrado"));
    }
}
