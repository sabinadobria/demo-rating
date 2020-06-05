package com.example.demo.repository;

import com.example.demo.model.Rating;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RatingRepository extends CrudRepository<Rating, Long> {
    List<Rating> findAllByBookId(Long bookId);
}
