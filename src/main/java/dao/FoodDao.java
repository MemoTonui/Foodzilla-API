package dao;

import models.Food;

import java.util.List;

public interface FoodDao {
    //Create
    void addFood(Food food);

    //Read
    List<Food> getAllFoods();

    Food findFoodById(int food_id);

    //Update;

    //Delete
    void clearAll();

}
