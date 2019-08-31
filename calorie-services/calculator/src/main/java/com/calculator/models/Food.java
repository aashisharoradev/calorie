package com.calculator.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="FOOD")
public class Food implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name="FOOD_ID")
    private int foodId;
    @Column(name="DISPLAY_NAME")
    private String foodName;

    public Food() {
    }
    public Food(int foodId, String foodName) {
        this.foodId = foodId;
        this.foodName = foodName;
    }

    public int getFoodId() {
        return foodId;
    }
    
    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public void setFoodId(int foodId) {
        this.foodId = foodId;
    }

}