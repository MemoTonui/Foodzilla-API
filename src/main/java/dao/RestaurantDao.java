package dao;

import models.Food;
import models.Restaurants;

import java.util.List;

public interface RestaurantDao {
    //Create
    void addRestaurant(Restaurants restaurants);
    void addFoodToRestaurant( Food food, Restaurants restaurants);

    //Read
    List<Restaurants> getAllRestaurants();
    Restaurants findRestaurantById( int restaurant_id);
    List<Food> getAllFoodsInRestaurant(int restaurant_id);

    //Update
    //Delete
    void clearAll();
}
