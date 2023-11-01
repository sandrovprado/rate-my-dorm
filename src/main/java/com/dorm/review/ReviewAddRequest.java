package com.dorm.review;

public record ReviewAddRequest(

         String name,
         String dormName,
         String description,
         String date,
         Integer rating
) {
}
