package com.dorm.review;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/reviews")
public class ReviewController {

    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping()
    public List<Review> getReviews() {
        return reviewService.getAllReviews();
    }

    @GetMapping("{reviewId}")
    public Review getReview(@PathVariable("reviewId") Integer reviewId) {
        return reviewService.getReview(reviewId);
    }

    @PostMapping()
    public void addReview(@RequestBody ReviewAddRequest reviewAddRequest) {
        reviewService.addReview(reviewAddRequest);
    }

    @DeleteMapping("{reviewId}")
    public void deleteReview(@PathVariable("reviewId") Integer reviewId) {
        reviewService.deleteReviewById(reviewId);
    }

    @PutMapping("{reviewId}")
    public void updateReview(@PathVariable("reviewId") Integer reviewId, @RequestBody ReviewUpdateRequest reviewUpdateRequest) {
        reviewService.updateReview(reviewId, reviewUpdateRequest);
    }


}
