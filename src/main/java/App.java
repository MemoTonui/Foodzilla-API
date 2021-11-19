import com.google.gson.Gson;
import models.Food;
import models.Restaurants;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import sql2o.Sql2oFoodDao;
import sql2o.Sql2oRestaurantDao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.*;
import static spark.Spark.after;

public class App {
    public static void main(String[] args){
        String connectionString ="jdbc:postgresql://localhost:5432/postgres";
        Sql2o sql2o = new Sql2o(connectionString,"postgres","chepkemoi1999.");

        Sql2oRestaurantDao restaurantDao = new Sql2oRestaurantDao(sql2o);
        Sql2oFoodDao foodDao = new Sql2oFoodDao(sql2o);
        Connection connection;
        Gson gson = new Gson();

        //post a new restaurant
        post("/restaurant/new","application/json",(request, response) -> {
            Restaurants restaurants = gson.fromJson(request.body(),Restaurants.class);
            restaurantDao.addRestaurant(restaurants);
            response.status(201);
            return gson.toJson(restaurants);
        });

        //Get all restaurants
        get("/restaurants","application/json",(request,response)->{
            if(restaurantDao.getAllRestaurants().size()>0){
                return gson.toJson(restaurantDao.getAllRestaurants());
            }
            else{
                return "{\"message\":\"There are No Restaurants Here!!\"}";
            }
        });
        //Get 1 restaurant(Find Restaurant)
        get("/restaurant/:id","application/json",(request,response)->{
          int id = Integer.parseInt(request.params("id"));
          Restaurants restaurants = restaurantDao.findRestaurantById(id);
          if(restaurants==null){
              return "{\"message\":\"The Restaurant with that id does not exist!!\"}";
          }
          else {
              return  gson.toJson(restaurantDao.findRestaurantById(id));
          }
        });
        //Get all foods in a restaurant
        get("/restaurant/:id/food", "application/json",(request,response)->{
            int id = Integer.parseInt(request.params("id"));
             Restaurants restaurantToFind = restaurantDao.findRestaurantById(id);
             List<Food> allFood;
            if (restaurantToFind == null) {
                return "{\"message\":\"Sorry!!This Restaurant Doesn't Exist!!.\"}";
            }
            allFood = foodDao.getTheFoodsInARestaurant(id);
           if(allFood.size()>0){
               return gson.toJson(allFood);            }
            else {
                return "{\"message\":\"Sorry!!This Restaurant is Empty!!.\"}";
            }

        });


        //Add Food
        post("/food/new","application/json",(request, response) -> {
            Food food = gson.fromJson(request.body(),Food.class);
            foodDao.addFood(food);
            response.status(201);
            return gson.toJson(food);
        });
        //Get all foods
        get("/foods","application/json",(request,response)->{
            if(foodDao.getAllFoods().size()>0){
                return gson.toJson(foodDao.getAllFoods());
            }
            else{
                return "{\"message\":\"There is no food here!!\"}";
            }
        });


        //FILTERS
       /* exception(ApiException.class, (exception, request, response) -> {
            ApiException err = exception;
            Map<String, Object> jsonMap = new HashMap<>();
            jsonMap.put("status", err.getStatusCode());
            jsonMap.put("errorMessage", err.getMessage());
            response.type("application/json");
            response.status(err.getStatusCode());
            response.body(gson.toJson(jsonMap));
        });*/


        after((request, response) ->{
            response.type("application/json");
        });
    }
}



