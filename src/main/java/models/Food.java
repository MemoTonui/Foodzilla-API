package models;

import java.util.Objects;

public class Food {
    private int food_id;
    private String food_name;
    private int food_ratings;
    private String food_image;
   private int restaurant_id;
   private int food_price;

    public Food() {
    }


    public Food(String food_name, int food_ratings, String food_image, int restaurant_id, int food_price) {
        this.food_name = food_name;
        this.food_ratings = food_ratings;
        this.food_image = food_image;
        this.restaurant_id = restaurant_id;
        this.food_price = food_price;
    }

    public int getFood_id() {
        return food_id;
    }

    public void setFood_id(int food_id) {
        this.food_id = food_id;
    }

    public String getFood_name() {
        return food_name;
    }

    public void setFood_name(String food_name) {
        this.food_name = food_name;
    }

    public int getFood_ratings() {
        return food_ratings;
    }

    public void setFood_ratings(int food_ratings) {
        this.food_ratings = food_ratings;
    }

    public String getFood_image() {
        return food_image;
    }

    public void setFood_image(String food_image) {
        this.food_image = food_image;
    }

    public int getRestaurant_id() {
        return restaurant_id;
    }

    public void setRestaurant_id(int restaurant_id) {
        this.restaurant_id = restaurant_id;
    }

    public int getFood_price() {
        return food_price;
    }

    public void setFood_price(int food_price) {
        this.food_price = food_price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Food)) return false;
        Food food = (Food) o;
        return food_id == food.food_id && food_ratings == food.food_ratings && restaurant_id == food.restaurant_id && food_price == food.food_price && food_name.equals(food.food_name) && food_image.equals(food.food_image);
    }

    @Override
    public int hashCode() {
        return Objects.hash(food_id, food_name, food_ratings, food_image, restaurant_id, food_price);
    }
}
