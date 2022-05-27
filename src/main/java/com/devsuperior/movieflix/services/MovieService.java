package com.devsuperior.movieflix.services;

import com.devsuperior.movieflix.entities.Movie;
import com.devsuperior.movieflix.dto.MovieByGenreDTO;
import com.devsuperior.movieflix.dto.MovieDTO;
import com.devsuperior.movieflix.dto.ReviewDTO;
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
    public MovieDTO findById(Long id) {
        return new MovieDTO(findMovieById(id));
    }

    @Transactional(readOnly = true)
    public List<ReviewDTO> findReviewsByMovieId(Long id) {
        return reviewRepository.findAllByMovie(new Movie(id)).stream().map(ReviewDTO::new).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public Page<MovieByGenreDTO> findAllByGenreId(Long genreId, Pageable pageable) {
        return repository.findAllByGenre((genreId == 0) ? null : genreId, pageable).map(MovieByGenreDTO::new);
    }

    private Movie findMovieById(Long id) {
        return repository.findById(id).orElseThrow(() -> new DataNotFoundException(
                "Filme não encontrado id: " + id + " entity: " + Movie.class.getName()));
    }



}
