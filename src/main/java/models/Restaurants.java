package models;

public class Restaurants {
    private int id;
    private String name;
    private float rating;
    private String location;
    private String image_url;
    private Boolean closed;
    private Double latitude;
    private Double longitude;


    public Restaurants() {

    }

    public Restaurants(String name, float rating, String location, String image_url, Boolean closed, Double latitude, Double longitude) {
        this.name = name;
        this.rating = rating;
        this.location = location;
        this.image_url = image_url;
        this.closed = closed;
        this.latitude = latitude;
        this.longitude = longitude;

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

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public Boolean getClosed() {
        return closed;
    }

    public void setClosed(Boolean closed) {
        this.closed = closed;
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


}