package com.phalves.restaurantmenu.service;

import com.phalves.restaurantmenu.exception.DatabaseException;
import com.phalves.restaurantmenu.mapper.FoodMapper;
import com.phalves.restaurantmenu.model.dto.FoodRequestDTO;
import com.phalves.restaurantmenu.model.dto.FoodResponseDTO;
import com.phalves.restaurantmenu.model.entity.Food;
import com.phalves.restaurantmenu.repository.FoodRepository;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class FoodService {

    @Autowired
    private FoodRepository repository;

    @Autowired
    private FoodMapper mapper;

    @Transactional
    public void create(FoodRequestDTO request) {
//        try {
//            Food food = new Food(data);
//            repository.save(food);
//        } catch () {
//
//        }
        Food food = new Food(request);
        repository.save(food);
    }

    @Transactional(readOnly = true)
    public List<FoodResponseDTO> findAll() {
        List<Food> foodList = repository.findAll();
        return foodList.stream().map(f -> new FoodResponseDTO(f)).toList();
    }

    @Transactional(readOnly = true)
    public List<FoodResponseDTO> findAllByTitleContaining(String title) {
        List<Food> foodList = repository.findByTitleContainingIgnoreCase(title);
        return foodList.stream().map(f -> new FoodResponseDTO(f)).toList();
    }

    @Transactional(readOnly = true)
    public FoodResponseDTO findById(Long id) {
        var food = repository.findById(id).get();
        return new FoodResponseDTO(food);
    }

    @Transactional
    public FoodRequestDTO update(Long id, FoodRequestDTO request) {
        try {
            Food food = repository.getReferenceById(id);
            food.setTitle(request.title());
            food.setImage(request.image());
            food.setDescription(request.description());
            food.setPrice(request.price());
            return new FoodRequestDTO(food);
        } catch (EntityNotFoundException e) {
            throw new DatabaseException("Id not find " + id);
        }
    }

    @Transactional
    public void delete(Long id) {
        repository.deleteById(id);
    }

}
