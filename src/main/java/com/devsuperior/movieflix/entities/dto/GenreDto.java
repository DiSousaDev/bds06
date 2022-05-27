package com.devsuperior.movieflix.entities.dto;

import com.devsuperior.movieflix.entities.Genre;

public class GenreDto {

    private Long id;
    private String name;

    public GenreDto() {
    }

    public GenreDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public GenreDto(Genre entity) {
        id = entity.getId();
        name = entity.getName();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}
