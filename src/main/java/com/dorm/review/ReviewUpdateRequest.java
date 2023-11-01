package com.dorm.review;

public record ReviewUpdateRequest(
        String name,
        String dormName,
        String description,
        String date,
        Integer rating ) {
}
