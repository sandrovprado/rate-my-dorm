package com.dorm.review;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository("Jpa")
public class ReviewJPADataAccessService implements ReviewDao{

    private final ReviewRepository reviewRepository;

    public ReviewJPADataAccessService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public List<Review> selectAllReviews() {
        return reviewRepository.findAll();
    }

    @Override
    public Optional<Review> selectReviewById(Integer id) {
        return reviewRepository.findById(id);
    }

    @Override
    public void createReview(Review review) {
        reviewRepository.save(review);
    }

    @Override
    public void deleteReviewById(Integer id) {
        reviewRepository.deleteById(id);
    }

    @Override
    public void updateReview(Review update) {
        reviewRepository.save(update);
    }

    @Override
    public boolean existReviewWithId(Integer id) {
        return reviewRepository.existsReviewById(id);
    }
}
