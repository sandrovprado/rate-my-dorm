package com.dorm;

import com.dorm.review.Review;
import com.dorm.review.ReviewRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class,args);
    }
    @Bean
    CommandLineRunner runner(ReviewRepository reviewRepository){

        return args -> {
            Review amy = new Review("amy","ROGERS HALL","very clean dorm","5/15/2019",5);
            Review rob = new Review("rob","BARTLETT HALL","Too much noise ","1/23/2019",2);

            List<Review> review = List.of(amy,rob);
            reviewRepository.saveAll(review);
        };
    }
}
