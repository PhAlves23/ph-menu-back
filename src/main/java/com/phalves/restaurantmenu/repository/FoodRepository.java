package com.phalves.restaurantmenu.repository;

import com.phalves.restaurantmenu.model.entity.Food;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FoodRepository extends JpaRepository<Food, Long> {

    List<Food> findByTitleContainingIgnoreCase(String title);

}
