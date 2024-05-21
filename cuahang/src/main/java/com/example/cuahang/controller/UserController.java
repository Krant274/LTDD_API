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

import com.example.cuahang.entity.User;
import com.example.cuahang.repository.UserRepository;



@RestController
@RequestMapping(path = "/api/appfood/user")
public class UserController {
	
	@Autowired
	private UserRepository repository;
	
	@GetMapping
	public ResponseEntity<?> getAllUser() {
		return ResponseEntity.ok().body(repository.findAll());
	}
	
	@PostMapping
    public ResponseEntity<User> postUser(@RequestBody User newUser) {
		User savedUser = repository.save(newUser);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }
	
	@DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") Integer id) {
        Optional<User> userOptional = repository.findById(id);

        if (userOptional.isPresent()) {
            repository.deleteById(id);
            return ResponseEntity.noContent().build(); // 204 No Content on success
        } else {
            return ResponseEntity.notFound().build(); // 404 Not Found if not found
        }
    }
	

}
