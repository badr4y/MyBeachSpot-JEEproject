package com.example.mybeachspot;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Beach {

    private int id;
    BeachInfo beachinfo;

    Api_response weather;

    List<BeachReview> beachReviews = new ArrayList<>();

    @Override
    public String toString() {
        return "Beach{" +
                "beachinfo=" + beachinfo +
                ", weather=" + weather +
                ", beachReviews=" + beachReviews +
                '}';
    }

    public List<BeachReview> getBeachReviews() {
        return beachReviews;
    }

    public void setBeachReviews(List<BeachReview> beachReviews) {
        this.beachReviews = beachReviews;
    }

    public Beach(int id, BeachInfo beachinfo, Api_response weather, List<BeachReview> beachReviews) {
        this.id=id;
        this.beachinfo = beachinfo;
        this.weather = weather;
        this.beachReviews=beachReviews;
    }


    public BeachInfo getBeachinfo() {
        return beachinfo;
    }

    public void setBeachinfo(BeachInfo beachinfo) {
        this.beachinfo = beachinfo;
    }

    public Api_response getWeather() {
        return weather;
    }

    public void setWeather(Api_response weather) {
        this.weather = weather;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}

