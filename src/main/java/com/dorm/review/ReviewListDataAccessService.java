package com.dorm.review;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository("List")
public class ReviewListDataAccessService implements ReviewDao{

    private static List<Review> reviewList;

    static {
        reviewList = new ArrayList<>();
        Review amy = new Review(1,"amy","ROGERS HALL","very clean dorm","5/15/2019",5);
        Review rob = new Review(2,"rob","BARTLETT HALL","Too much noise ","1/23/2019",2);
        reviewList.add(amy);
        reviewList.add(rob);
    }

    @Override
    public List<Review> selectAllReviews() {
        return reviewList;
    }

    @Override
    public Optional<Review> selectReviewById(Integer id) {
        return reviewList.stream()
                .filter(review -> review.getId().equals(id))
                .findFirst();
    }

    @Override
    public void createReview(Review review) {
        reviewList.add(review);
    }

    @Override
    public void deleteReviewById(Integer id) {
        reviewList.stream()
                .filter(review -> review.getId().equals(id))
                .findFirst()
                .ifPresent(reviewList::remove);
    }

    @Override
    public void updateReview(Review update) {
        reviewList.add(update);
    }

    @Override
    public boolean existReviewWithId(Integer id) {
        return reviewList.stream()
                .anyMatch(review -> review.getId().equals(id));
    }
}
