package com.devsuperior.movieflix.entities.dto;

import com.devsuperior.movieflix.entities.User;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class UserDto {

    private Long id;

    @NotBlank(message = "Campo obrigatório.")
    private String name;

    @Email(message = "E-mail inválido.")
    private String email;

    public UserDto() {
    }

    public UserDto(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public UserDto(User entity) {
        id = entity.getId();
        name = entity.getName();
        email = entity.getEmail();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

}
