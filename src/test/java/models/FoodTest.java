package models;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

public class FoodTest {
    @Before
    public void setUp() throws Exception{

    }
    @After
    public  void tearDown() throws Exception{

    }
    @Test
    public  void Food_InitiatesObjectCorrectly_true(){
       Food food = new Food( "Chips",5,"https://chipo.com",1,200);
        assertTrue(food instanceof Food);
    }
    @Test
    public  void setName_setsNAmeCorrectly_true(){
        Food food = new Food( "Chips",5,"https://chipo.com",1,200);
        food.setFood_name("Matoke");
        assertNotEquals("Chips",food.getFood_name());
    }
    @Test
    public  void getName_getsNAmeCorrectly_true(){
        Food food = new Food( "Chips",5,"https://chipo.com",1,200);
        assertEquals("Chips",food.getFood_name());
    }

    @Test
    public  void setRatings_setsRatingsCorrectly_true(){
        Food food = new Food( "Chips",5,"https://chipo.com",1,200);
        food.setFood_rating(3);
        assertNotEquals(5,food.getFood_rating());
    }
    @Test
    public  void getRatings_getsRatingsCorrectly_true(){
        Food food = new Food( "Chips",5,"https://chipo.com",1,200);
        assertEquals(5,food.getFood_rating());
    }

    @Test
    public  void setImage_setsImageCorrectly_true(){
        Food food = new Food( "Chips",5,"https://chipo.com",1,200);
        food.setFood_image("https://matoke.com");
        assertNotEquals("https://chipo.com",food.getFood_image());
    }
    @Test
    public  void getImage_getsImageCorrectly_true(){
        Food food = new Food( "Chips",5,"https://chipo.com",1,200);
        assertEquals("https://chipo.com",food.getFood_image());
    }

    @Test
    public  void setPrice_setsPriceCorrectly_true(){
        Food food = new Food( "Chips",5,"https://chipo.com",1,200);
        food.setFood_price(50);
        assertNotEquals(200,food.getFood_price());
    }
    @Test
    public  void getPrice_getsPriceCorrectly_true(){
        Food food = new Food( "Chips",5,"https://chipo.com",1,200);
        assertEquals(200,food.getFood_price());
    }

}
