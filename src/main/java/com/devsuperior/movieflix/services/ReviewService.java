package com.devsuperior.movieflix.services;

import com.devsuperior.movieflix.entities.Movie;
import com.devsuperior.movieflix.entities.Review;
import com.devsuperior.movieflix.dto.ReviewDTO;
import com.devsuperior.movieflix.dto.ReviewInsertDTO;
import com.devsuperior.movieflix.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private UserService userService;

    @Transactional
    public ReviewDTO saveReview(ReviewInsertDTO review) {
        return new ReviewDTO(reviewRepository.save(getNewReview(review)));
    }

    private Review getNewReview(ReviewInsertDTO review) {
        Review rev = new Review();
        rev.setText(review.getText());
        rev.setMovie(new Movie(review.getMovieId()));
        rev.setUser(userService.getUserLogged());
        return rev;
    }

}
