package com.forum.ratingservice;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RatingRepository extends JpaRepository<Rating, Long> {
//    void setRating(Rating rating) throws RatingException;
//    int getAverageRating(String game) throws RatingException;
//    int getRating(String game, Long id) throws RatingException;
//    void reset() throws RatingException;
}
