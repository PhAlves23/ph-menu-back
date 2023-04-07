package com.phalves.restaurantmenu.model.dto;

import com.phalves.restaurantmenu.model.entity.Food;

public record FoodResponseDTO(Long id,String title, String image, String description, Float price) {

    public FoodResponseDTO(Food food){
        this(food.getId(), food.getTitle(), food.getImage(), food.getDescription(), food.getPrice());
    }

}
