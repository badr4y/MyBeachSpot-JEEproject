package com.example.mybeachspot;

public class BeachReview {
    private String beachName;
    private String review;

    public BeachReview(String beachName, String review) {
        this.beachName = beachName;
        this.review = review;
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
