package com.adisvara.movies.service;

import com.adisvara.movies.model.Movie;
import com.adisvara.movies.model.Review;
import com.adisvara.movies.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    public List<Review> allReviews(){
        return reviewRepository.findAll();
    }

    public Review createReview(String reviewBody, String imdbId){
        // Create a new review with the provided body
        Review review = reviewRepository.insert(new Review(reviewBody));
        
        // Now update the movie with the saved review that has an ID
        mongoTemplate.update(Movie.class)
                .matching(Criteria.where("imdbId").is(imdbId))
                .apply(new Update().push("reviewIds").value(review))
                .first();
                
        return review;
    }
}
