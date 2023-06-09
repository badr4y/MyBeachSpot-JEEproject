package com.example.mybeachspot;

import java.util.List;

public class BeachReview {
    private String beachName;
    private String review;
    private int rating;

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public BeachReview(String beachName, String review, int rating) {
        this.beachName = beachName;
        this.review = review;
        this.rating= rating;
    }

    public String getBeachName() {
        return beachName;
    }

    public void setBeachName(String beachName) {
        this.beachName = beachName;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }
}
