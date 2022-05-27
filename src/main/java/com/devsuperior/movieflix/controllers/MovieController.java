package com.devsuperior.movieflix.controllers;

import com.devsuperior.movieflix.entities.dto.MovieByGenreDto;
import com.devsuperior.movieflix.entities.dto.MovieDto;
import com.devsuperior.movieflix.entities.dto.ReviewDto;
import com.devsuperior.movieflix.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/movies")
public class MovieController {

    @Autowired
    private MovieService service;

    @GetMapping
    public ResponseEntity<Page<MovieByGenreDto>> findAllByGenreId(
            @RequestParam(defaultValue = "0") Long genreId,
            Pageable pageable
    ) {
        Page<MovieByGenreDto> page = service.findAllByGenreId(genreId, pageable);
        return ResponseEntity.ok().body(page);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<MovieDto> findById(@PathVariable Long id) {
        MovieDto obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping(value = "/{id}/reviews")
    public ResponseEntity<List<ReviewDto>> findReviewsByMovieId(@PathVariable Long id) {
        List<ReviewDto> list = service.findReviewsByMovieId(id);
        return ResponseEntity.ok().body(list);
    }

}
