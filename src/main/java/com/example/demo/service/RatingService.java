package com.example.demo.service;

import com.example.demo.model.Rating;
import com.example.demo.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingService {

    @Autowired
    private RatingRepository ratingRepository;

    public List<Rating> findRatingsByBookId(Long bookId) {
        if(bookId.equals(0L)) {
            return (List<Rating>) ratingRepository.findAll();
        }
        return ratingRepository.findAllByBookId(bookId);
    }

    public Rating createRating(Rating rating) {
        return ratingRepository.save(rating);
    }

    public void deleteRating(Long ratingId) {
        ratingRepository.deleteById(ratingId);
    }

    public Rating updateRating( Rating rating,  Long ratingId) {
        Rating rating1 = ratingRepository.findById(ratingId).get();
        rating1.setStars(rating.getStars());
        return ratingRepository.save(rating1);
    }


}
