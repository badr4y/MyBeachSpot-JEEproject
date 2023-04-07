package com.example.mybeachspot;
public class Feedback {
    private int id;
    private String name;
    private String email;
    private int rating;
    private String feedback;

    public Feedback(String name, String email, int rating, String feedback) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.rating = rating;
        this.feedback = feedback;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
}
