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

import com.example.cuahang.entity.Drink;
import com.example.cuahang.repository.DrinkRepository;

@RestController
@RequestMapping(path = "/api/appfood/drink")
public class DrinkController { 

    @Autowired
    private DrinkRepository repository;

    @GetMapping
    public ResponseEntity<?> getAllDrink() {
        return ResponseEntity.ok().body(repository.findAll());
    }

    @PostMapping
    public ResponseEntity<Drink> postDrink(@RequestBody Drink newDrink) {
        Drink savedDrink = repository.save(newDrink);
        return new ResponseEntity<>(savedDrink, HttpStatus.CREATED);
    }
   
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") Integer id) {
        Optional<Drink> drinkOptional = repository.findById(id);

        if (drinkOptional.isPresent()) {
            repository.deleteById(id);
            return ResponseEntity.noContent().build(); // 204 No Content on success
        } else {
            return ResponseEntity.notFound().build(); // 404 Not Found if not found
        }
    }
}
