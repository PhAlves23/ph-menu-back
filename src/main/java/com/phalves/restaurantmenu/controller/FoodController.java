package com.phalves.restaurantmenu.controller;

import com.phalves.restaurantmenu.model.dto.FoodRequestDTO;
import com.phalves.restaurantmenu.model.dto.FoodResponseDTO;
import com.phalves.restaurantmenu.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/foods")
public class FoodController {

    @Autowired
    private FoodService service;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public ResponseEntity<FoodResponseDTO> create(@RequestBody FoodRequestDTO data) {
        service.create(data);
        return ResponseEntity.status(201).build();
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    public ResponseEntity<List<FoodResponseDTO>> findAll() {
        List<FoodResponseDTO> foodList = service.findAll();
        return ResponseEntity.ok(foodList);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("{id}")
    public ResponseEntity findById(@PathVariable Long id) {
       FoodResponseDTO food =  service.findById(id);
        return ResponseEntity.ok(food);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/name")
    public ResponseEntity findAllByTitleContaining(@RequestParam String title){
        List<FoodResponseDTO> foods = service.findAllByTitleContaining(title);
        return ResponseEntity.ok(foods);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PutMapping("{id}")
    public ResponseEntity update(@PathVariable Long id, @RequestBody FoodRequestDTO request) {
        FoodRequestDTO foodRequestDTO = service.update(id, request);
        return ResponseEntity.ok().build();
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
