package com.calculator.dao;

import com.calculator.models.Food;

import org.springframework.stereotype.Repository;

@Repository
public class FoodDao extends HibernateDao<Food> {
    public FoodDao() {
        super();
        setClazz(Food.class);
    }
}