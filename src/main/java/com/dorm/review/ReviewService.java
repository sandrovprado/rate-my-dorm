package com.dorm.review;

import com.dorm.exception.RequestValidationException;
import com.dorm.exception.ResourceNotFound;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {

    private ReviewDao reviewDao;

    public ReviewService(@Qualifier("Jpa") ReviewDao reviewDao) {
        this.reviewDao = reviewDao;
    }

    public List<Review> getAllReviews() {
        return reviewDao.selectAllReviews();
    }

    public Review getReview(Integer id) {
        return reviewDao.selectReviewById(id)
                .orElseThrow(() -> new ResourceNotFound(
                        "Review with id [%s] not found" .formatted(id)
                ));
    }

    public void addReview(ReviewAddRequest reviewAddRequest) {
        Review review = new Review(
                reviewAddRequest.name(),
                reviewAddRequest.dormName(),
                reviewAddRequest.description(),
                reviewAddRequest.date(),
                reviewAddRequest.rating());

        reviewDao.createReview(review);
    }

    public void deleteReviewById(Integer reviewId) {
        if (!reviewDao.existReviewWithId(reviewId)) {
            throw new ResourceNotFound("Review with id [%s] not found" .formatted(reviewId));
        }
        reviewDao.deleteReviewById(reviewId);
    }

    public void updateReview(Integer reviewId, ReviewUpdateRequest reviewUpdateRequest) {
        Review review = getReview(reviewId);

        boolean changes = false;

        if (reviewUpdateRequest.name() != null && !reviewUpdateRequest.name().equals(review.getName())) {
            review.setName(reviewUpdateRequest.name());
            changes = true;
        }

        if (reviewUpdateRequest.dormName() != null && !reviewUpdateRequest.dormName().equals(review.getDorm_name())) {
            review.setDorm_name(reviewUpdateRequest.dormName());
            changes = true;
        }

        if (reviewUpdateRequest.description() != null && !reviewUpdateRequest.description().equals(review.getDescription())) {
            review.setDescription(reviewUpdateRequest.description());
            changes = true;
        }

        if (reviewUpdateRequest.date() != null && !reviewUpdateRequest.date().equals(review.getDate())) {
            review.setDate(reviewUpdateRequest.date());
            changes = true;
        }

        if (reviewUpdateRequest.rating() != null && !reviewUpdateRequest.rating().equals(review.getRating())) {
            review.setRating(reviewUpdateRequest.rating());
            changes = true;
        }

        if(!changes){
            throw new RequestValidationException("No data changes found");
        }

        reviewDao.updateReview(review);
    }
}
