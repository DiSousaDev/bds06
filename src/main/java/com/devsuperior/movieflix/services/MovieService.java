package com.devsuperior.movieflix.services;

import com.devsuperior.movieflix.entities.Movie;
import com.devsuperior.movieflix.entities.dto.MovieByGenreDto;
import com.devsuperior.movieflix.entities.dto.MovieDto;
import com.devsuperior.movieflix.entities.dto.ReviewDto;
import com.devsuperior.movieflix.repositories.MovieRepository;
import com.devsuperior.movieflix.repositories.ReviewRepository;
import com.devsuperior.movieflix.services.exceptions.DataNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieService {

    @Autowired
    private MovieRepository repository;

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private UserService userService;

    @Transactional(readOnly = true)
    public MovieDto findById(Long id) {
        return new MovieDto(findMovieById(id));
    }

    @Transactional(readOnly = true)
    public List<ReviewDto> findReviewsByMovieId(Long id) {
        return reviewRepository.findAllByMovie(new Movie(id)).stream().map(ReviewDto::new).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public Page<MovieByGenreDto> findAllByGenreId(Long genreId, Pageable pageable) {
        return repository.findAllByGenre((genreId == 0) ? null : genreId, pageable).map(MovieByGenreDto::new);
    }

    private Movie findMovieById(Long id) {
        return repository.findById(id).orElseThrow(() -> new DataNotFoundException(
                "Filme não encontrado id: " + id + " entity: " + Movie.class.getName()));
    }



}
