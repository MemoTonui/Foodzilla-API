package dao;

import models.Food;
import models.Restaurants;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import sql2o.Sql2oFoodDao;
import sql2o.Sql2oRestaurantDao;

public class Sql2oRestaurantTest {
    public static Sql2oRestaurantDao sql2oRestaurantDao;
    public static Sql2oFoodDao sql2oFoodDao;
    private Connection conn;

    @Before
    public void setUp() throws Exception {

        String connectionString = "jdbc:postgresql://localhost:5432/postgres/foodzilla_test";
        Sql2o sql2o = new Sql2o(connectionString, "tonui", "chepkemoi1999.");

        //Sql2o sql2o = new Sql2o(connectionString, "", "");
        sql2oRestaurantDao = new Sql2oRestaurantDao(sql2o);
        sql2oFoodDao = new Sql2oFoodDao(sql2o);
        conn= sql2o.open();
    }
    @After
    public void tearDown() throws Exception {
        sql2oRestaurantDao.clearAll();
        sql2oFoodDao.clearAll();
        conn.close();
    }}
  /*  @Test
    public void addRestaurant_addsRestaurantCorrectly_true() throws Exception{
        Restaurants restaurants = setUpNewRestaurant();
        int restaurant_id = restaurants.getRestaurant_id();
        sql2oRestaurantDao.addRestaurant(restaurants);
        assertNotEquals(restaurant_id,restaurants.getRestaurant_id());

    }

    //Helper
    private Restaurants setUpNewRestaurant(){
        return new Restaurants("Kempinski",3,"Madaraka","https://ggg.com",111,222);
    }
    private Food setUpNewFood(){
        return new Food( "Chips",5,"https://chipo.com",1,200);
    }
}*/
