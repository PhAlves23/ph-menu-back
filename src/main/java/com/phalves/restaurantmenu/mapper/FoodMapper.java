package com.phalves.restaurantmenu.mapper;

import com.phalves.restaurantmenu.model.dto.FoodRequestDTO;
import com.phalves.restaurantmenu.model.dto.FoodResponseDTO;
import com.phalves.restaurantmenu.model.entity.Food;
import org.springframework.stereotype.Component;

@Component
public class FoodMapper {

    public static Food fromResponseDTO(FoodRequestDTO request) {
        Food food = new Food(request);
        food.setTitle(request.title());
        food.setImage(request.image());
        food.setPrice(request.price());

        return food;
    }

}
