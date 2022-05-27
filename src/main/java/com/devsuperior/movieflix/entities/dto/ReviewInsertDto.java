package com.devsuperior.movieflix.entities.dto;

import javax.validation.constraints.NotBlank;

public class ReviewInsertDto {

    @NotBlank(message = "Campo requerido")
    private String text;
    private Long movieId;

    public ReviewInsertDto() {
    }

    public ReviewInsertDto(String text, Long movieId) {
        this.text = text;
        this.movieId = movieId;
    }

    public String getText() {
        return text;
    }

    public Long getMovieId() {
        return movieId;
    }
}
