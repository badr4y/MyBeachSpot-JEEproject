package com.example.mybeachspot;

public class BeachInfo {
    String name;
    String description;
    String parking;
    String disabled_access;
    String restrooms;
    String dog_friendly;
    String sandy_beach;
    String fishing;
    String boating;
    Double latitude;
    Double longitude;
    String location;
    String photo_1;
    String photo_2;
    String photo_3;
    String photo_4;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getParking() {
        return parking;
    }

    public void setParking(String parking) {
        this.parking = parking;
    }

    public String getDisabled_access() {
        return disabled_access;
    }

    public void setDisabled_access(String disabled_access) {
        this.disabled_access = disabled_access;
    }

    public String getRestrooms() {
        return restrooms;
    }

    public void setRestrooms(String restrooms) {
        this.restrooms = restrooms;
    }

    public String getDog_friendly() {
        return dog_friendly;
    }

    public void setDog_friendly(String dog_friendly) {
        this.dog_friendly = dog_friendly;
    }

    public String getSandy_beach() {
        return sandy_beach;
    }

    public void setSandy_beach(String sandy_beach) {
        this.sandy_beach = sandy_beach;
    }

    public String getFishing() {
        return fishing;
    }

    public void setFishing(String fishing) {
        this.fishing = fishing;
    }

    public String getBoating() {
        return boating;
    }

    public void setBoating(String boating) {
        this.boating = boating;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPhoto_1() {
        return photo_1;
    }

    public void setPhoto_1(String photo_1) {
        this.photo_1 = photo_1;
    }

    public String getPhoto_2() {
        return photo_2;
    }

    public void setPhoto_2(String photo_2) {
        this.photo_2 = photo_2;
    }

    public String getPhoto_3() {
        return photo_3;
    }

    public void setPhoto_3(String photo_3) {
        this.photo_3 = photo_3;
    }

    public String getPhoto_4() {
        return photo_4;
    }

    public void setPhoto_4(String photo_4) {
        this.photo_4 = photo_4;
    }





    public BeachInfo(String name, String description, String parking, String disabled_access, String restrooms, String dog_friendly, String sandy_beach, String fishing, String boating, Double latitude, Double longitude, String location, String photo_1, String photo_2, String photo_3, String photo_4) {
        this.name = name;
        this.description = description;
        this.parking = parking;
        this.disabled_access = disabled_access;
        this.restrooms = restrooms;
        this.dog_friendly = dog_friendly;
        this.sandy_beach = sandy_beach;
        this.fishing = fishing;
        this.boating = boating;
        this.latitude = latitude;
        this.longitude = longitude;
        this.location = location;
        this.photo_1 = photo_1;
        this.photo_2 = photo_2;
        this.photo_3 = photo_3;
        this.photo_4 = photo_4;
    }

    @Override
    public String toString() {
        return "BeachInfo{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", parking='" + parking + '\'' +
                ", disabled_access='" + disabled_access + '\'' +
                ", restrooms='" + restrooms + '\'' +
                ", dog_friendly='" + dog_friendly + '\'' +
                ", sandy_beach='" + sandy_beach + '\'' +
                ", fishing='" + fishing + '\'' +
                ", boating='" + boating + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", location='" + location + '\'' +
                ", photo_1='" + photo_1 + '\'' +
                ", photo_2='" + photo_2 + '\'' +
                ", photo_3='" + photo_3 + '\'' +
                ", photo_4='" + photo_4 + '\'' +
                '}';
    }
}
