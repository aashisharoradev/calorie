package com.calculator.service;

import java.util.List;

import com.calculator.dao.FoodDao;
import com.calculator.models.Food;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FoodService {
    
    @Autowired
    private FoodDao foodDao;

    public List<Food> findAll() {
        return foodDao.findAll();
    }
}