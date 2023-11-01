package com.dorm.review;

import java.util.List;
import java.util.Optional;

public interface ReviewDao {

    List<Review> selectAllReviews();
    Optional<Review> selectReviewById(Integer id);
    void createReview(Review review);
    void deleteReviewById(Integer id);
    void updateReview(Review update);
    boolean existReviewWithId(Integer id);
}
