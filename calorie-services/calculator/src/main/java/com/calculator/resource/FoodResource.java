package com.calculator.resource;

import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.calculator.models.Food;
import com.calculator.service.FoodService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@CrossOrigin(origins = "http://localhost:3000/", allowedHeaders = {"*"})
@RequestMapping("/calculator")
public class FoodResource {

    @Autowired
    private FoodService foodService;

    @RequestMapping(method = RequestMethod.GET, value = "/all/{foodexp}")
    public List<Food> getFoods(@PathVariable("foodexp") String foodexp, HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "http://localhost:3000");
        return foodService.findAll();
    }
}