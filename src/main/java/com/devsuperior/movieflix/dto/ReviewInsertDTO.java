package com.devsuperior.movieflix.dto;

import javax.validation.constraints.NotBlank;

public class ReviewInsertDTO {

    @NotBlank(message = "Campo requerido")
    private String text;
    private Long movieId;

    public ReviewInsertDTO() {
    }

    public ReviewInsertDTO(String text, Long movieId) {
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
