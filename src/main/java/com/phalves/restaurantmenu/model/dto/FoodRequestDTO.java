package com.phalves.restaurantmenu.model.dto;

import com.phalves.restaurantmenu.model.entity.Food;

public record FoodRequestDTO(String title, String image, String description, Float price) {

    public FoodRequestDTO(Food food){
        this(food.getTitle(), food.getImage(), food.getDescription(), food.getPrice());
    }


}
