package com.adisvara.movies.controller;

import com.adisvara.movies.model.Review;
import com.adisvara.movies.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @PostMapping()
    public ResponseEntity<Review> createReview(@RequestBody Map<String, String> payload){
        String reviewBody = payload.get("reviewBody");
        String imdbId = payload.get("imdbId");
        
        if (reviewBody == null || imdbId == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        
        return new ResponseEntity<>(reviewService.createReview(reviewBody, imdbId), HttpStatus.CREATED);
    }
    
    @GetMapping
    public ResponseEntity<List<Review>> getAllReviews(){
        return new ResponseEntity<>(reviewService.allReviews(), HttpStatus.OK);
    }
}
