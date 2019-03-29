package com.example.ahattab.final_exam;

import java.io.Serializable;
import java.util.Date;

public class Food implements Serializable{


        public static final String TABLE_NAME = "food";
        public static final String COLUMN_DATE= "food_id";
        public static final String COLUMN_FOODNAME= "food_name";
        public static final String COLUMN_CALORIES= "food_calories";
        public static final String COLUMN_QUANTITY= "food_quantity";

        public static final String CREATE_TABLE =
                "CREATE TABLE " + TABLE_NAME
                        + "("
                        + COLUMN_DATE + " TEXT,"
                        + COLUMN_FOODNAME + " TEXT,"
                        + COLUMN_QUANTITY + " INTEGER,"
                        + COLUMN_CALORIES + " INTEGER)";

    String firstDate;
    String foodName;
    Integer calories;
    Integer quantity;

    public Food() {

    }

    public Food(String firstDate, String foodName, Integer calories, Integer quantity) {
        this.firstDate = firstDate;
        this.foodName = foodName;
        this.calories = calories;
        this.quantity = quantity;
    }

    public String getFirstDate() {
        return firstDate;
    }

    public void setFirstDate(String firstDate) {
        this.firstDate = firstDate;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public Integer getCalories() {
        return calories;
    }

    public void setCalories(Integer calories) {
        this.calories = calories;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
