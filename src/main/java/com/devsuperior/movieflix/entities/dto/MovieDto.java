package com.devsuperior.movieflix.entities.dto;

import java.util.ArrayList;
import java.util.List;

public class MovieDto {

    private Long id;
    private String title;
    private String subTitle;
    private Integer year;
    private String imgUrl;
    private String synopsis;
    private GenreDto genre;
    private List<ReviewDto> reviews = new ArrayList<>();

    public MovieDto() {
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public Integer getYear() {
        return year;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public GenreDto getGenre() {
        return genre;
    }

    public List<ReviewDto> getReviews() {
        return reviews;
    }
}
