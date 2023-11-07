package com.dorm.review;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review,Integer> {

    boolean existsReviewById(Integer id);
}
