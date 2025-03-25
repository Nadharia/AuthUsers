package com.example.AuthUsers.Models.Roles;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Rol {
    private Long id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;
}
