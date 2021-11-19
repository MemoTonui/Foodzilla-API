package sql2o;

import dao.FoodDao;
import models.Food;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.ArrayList;
import java.util.List;

public class Sql2oFoodDao implements FoodDao {
    private Sql2o sql2o;
    public Sql2oFoodDao(Sql2o sql2o){
        this.sql2o = sql2o;
    }

    @Override
    public void addFood(Food food) {
        String addFood = "INSERT INTO food(food_name,food_rating, food_image,food_price, restaurant_id) VALUES (:food_name,:food_rating, :food_image,:food_price, :restaurant_id)";
        try(Connection con = sql2o.open()){
            int id = (int) con.createQuery(addFood, true).bind(food).executeUpdate().getKey();
            food.setFood_id(id);
        }catch (Sql2oException ex){
            System.out.println(ex);
        }
    }
    @Override
    public List<Food> getTheFoodsInARestaurant(int restaurant_id){
        try(Connection con = sql2o.open()){
            String sql = "SELECT * FROM food WHERE restaurant_id =:restaurant_id";
            return con.createQuery(sql).addParameter("restaurant_id",restaurant_id).executeAndFetch(Food.class);
        }
    }

    @Override
    public List<Food> getAllFoods() {
        String  getFoods = "SELECT * FROM food";
        try(Connection con = sql2o.open()){
            return con.createQuery(getFoods).executeAndFetch(Food.class);
        }

    }






    @Override
    public Food findFoodById(int food_id) {
        try(Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM food WHERE food_id = :food_id").addParameter("food_id",food_id).executeAndFetchFirst(Food.class);
        }

    }

    @Override
    public void clearAll() {
        try(Connection con = sql2o.open()){
            String drop = "DELETE FROM food";
            con.createQuery(drop).executeUpdate();
        }
        catch(Sql2oException ex){
            System.out.println(ex);
        }
    }
}
