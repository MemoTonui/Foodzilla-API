package sql2o;

import dao.RestaurantDao;
import models.Food;
import models.Restaurants;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.ArrayList;
import java.util.List;

public class Sql2oRestaurantDao implements RestaurantDao {
    private Sql2o sql2o;
    public Sql2oRestaurantDao(Sql2o sql2o){
        this.sql2o= sql2o;
    }

    @Override
    public void addRestaurant(Restaurants restaurants) {
        try(Connection con = sql2o.open()){
            String addRestaurants = "INSERT INTO restaurants( name,  rating,  location,  image_url,  latitude,  longitude, isclosed) VALUES (:name,  :rating,  :location,  :image_url,   :latitude,  :longitude, :isclosed  );";
            int restaurant_id =(int) con.createQuery(addRestaurants,true).bind(restaurants).executeUpdate().getKey();
            restaurants.setRestaurant_id(restaurant_id);
        }catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void addFoodToRestaurant(Food food, Restaurants restaurants) {
        try(Connection con = sql2o.open()) {
            String addFoodToRestaurant = "INSERT INTO food_restaurants(food_id, restaurant_id) VALUES (:food_id, :restaurant_id) ";
            con.createQuery(addFoodToRestaurant).addParameter("food_id",food.getFood_id()).addParameter("restaurant_id", restaurants.getRestaurant_id()).executeUpdate();
             String sizeQuery ="SELECT food_id FROM food_restaurants";
             List<Integer> size= con.createQuery(sizeQuery).executeAndFetch(Integer.class);
        }
        catch (Sql2oException e){
            System.out.println(e);
        }
    }

    @Override
    public List<Restaurants> getAllRestaurants() {
        String getRestaurants = "SELECT * FROM restaurants";
        try(Connection con = sql2o.open()) {
            return con.createQuery(getRestaurants).executeAndFetch(Restaurants.class);
        }
    }

    @Override
    public Restaurants findRestaurantById(int restaurant_id) {
        try(Connection con = sql2o.open()){
            return con.createQuery("SELECT * FROM restaurants WHERE restaurant_id=:restaurant_id").addParameter("restaurant_id",restaurant_id).executeAndFetchFirst(Restaurants.class);
        }

    }

    @Override
    public List<Food> getAllFoodsInRestaurant(int restaurant_id) {
        List <Food> food = new ArrayList<>();
        try(Connection con = sql2o.open()){
            String getAllFoodsInRestaurant ="SELECT food_id FROM food_restaurants WHERE restaurant_id=:restaurant_id";
            List<Integer> foodId = con.createQuery(getAllFoodsInRestaurant).addParameter("restaurant_id",restaurant_id).executeAndFetch(Integer.class);

            for(Integer id: foodId){
                String foodInRestaurant ="SELECT * FROM food WHERE food_id=:food_id";
                food.add(con.createQuery(foodInRestaurant).addParameter("food_id",id).executeAndFetchFirst(Food.class));
            }

        }
        return food;
    }

    @Override
    public void clearAll() {
        try(Connection con = sql2o.open()){
            String drop = "DELETE FROM restaurants";
            String dropFoodInRestaurants ="DELETE FROM food_restaurants";
            con.createQuery(drop).executeUpdate();
            con.createQuery(dropFoodInRestaurants).executeUpdate();
        }
        catch(Sql2oException e){
            System.out.println(e);
        }
    }
}
