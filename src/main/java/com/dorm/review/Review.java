package com.dorm.review;



import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Review {

    @Id
    @SequenceGenerator(
            name = "review_id_seq",
            sequenceName = "review_id_seq",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "review_id_seq"
    )
    private Integer id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String dorm_name;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private String date;
    @Column(nullable = false)
    private Integer rating;

    public Review(Integer id, String name, String dormName, String description, String date, Integer rating) {
        this.id = id;
        this.name = name;
        this.dorm_name = dormName;
        this.description = description;
        this.date = date;
        this.rating = rating;
    }

    public Review() {
    }

    public Review(String name, String dormName, String description, String date, Integer rating) {
        this.name = name;
        this.dorm_name = dormName;
        this.description = description;
        this.date = date;
        this.rating = rating;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDorm_name() {
        return dorm_name;
    }

    public void setDorm_name(String dormName) {
        this.dorm_name = dormName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Review review = (Review) o;
        return Objects.equals(id, review.id) && Objects.equals(name, review.name) && Objects.equals(dorm_name, review.dorm_name) && Objects.equals(description, review.description) && Objects.equals(date, review.date) && Objects.equals(rating, review.rating);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, dorm_name, description, date, rating);
    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dormName='" + dorm_name + '\'' +
                ", description='" + description + '\'' +
                ", date='" + date + '\'' +
                ", rating=" + rating +
                '}';
    }
}
