package dao;

import models.Food;

import java.util.List;

public interface FoodDao {
    //Create
    void addFood(Food food);

    //Read
    List<Food> getAllFoods();
    List<Food> getTheFoodsInARestaurant(int restaurant_id);
    Food findFoodById(int food_id);

    //Update;

    //Delete
    void clearAll();

}
