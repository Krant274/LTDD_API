package com.example.cuahang.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cuahang.entity.Food;
import com.example.cuahang.repository.FoodRepository;

@RestController
@RequestMapping(path = "/api/appfood/food")
public class FoodController {

    @Autowired
    private FoodRepository repository;

    @GetMapping
    public ResponseEntity<?> getAllFood() {
        return ResponseEntity.ok().body(repository.findAll());
    }

    @PostMapping
    public ResponseEntity<Food> postFood(@RequestBody Food newFood) {
        Food savedFood = repository.save(newFood);
        return new ResponseEntity<>(savedFood, HttpStatus.CREATED);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") Integer id) {
        Optional<Food> foodOptional = repository.findById(id);

        if (foodOptional.isPresent()) {
            repository.deleteById(id);
            return ResponseEntity.noContent().build(); // 204 No Content on success
        } else {
            return ResponseEntity.notFound().build(); // 404 Not Found if not found
        }
    }
}
