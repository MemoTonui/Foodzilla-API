SET MODE PostgresSQL;

CREATE  DATABASE foodzilla;
\c foodzilla

CREATE TABLE IF NOT EXISTS restaurants(   restaurant_id serial PRIMARY KEY,
                                          name VARCHAR,
                                          rating float,
                                          location VARCHAR ,
                                          image_url VARCHAR ,
                                          longitude double precision ,
                                          latitude double precision,
                                          isclosed boolean
);

CREATE TABLE IF NOT EXISTS food(
                                   food_id serial PRIMARY KEY,
                                   food_name VARCHAR,
                                   food_rating int,
                                   food_image VARCHAR ,
                                   food_price int,
                                   restaurant_id int
);
CREATE TABLE IF NOT EXISTS food_restaurants (
                                                 restaurant_id SERIAL PRIMARY KEY,
                                                food_id INT,
                                                 restaurant_id INT
);



CREATE DATABASE foodzilla_test WITH TEMPLATE foodzilla;





