package com.devsuperior.movieflix.entities.dto;

import java.util.ArrayList;
import java.util.List;

public class GenreDto {

    private Long id;
    private String name;
    private List<MovieDto> movies = new ArrayList<>();

    public GenreDto() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<MovieDto> getMovies() {
        return movies;
    }
}
