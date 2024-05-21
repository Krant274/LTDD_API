package com.example.cuahang.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cuahang.entity.Processed;
import com.example.cuahang.repository.ProcessedRepository;


@RestController
@RequestMapping(path = "/api/appfood/processed")
public class ProcessedController {
	
	@Autowired
	private ProcessedRepository repository;
	
	@GetMapping
	public ResponseEntity<?> getAllDonhang() {
		return ResponseEntity.ok().body(repository.findAll());
	}
	
	@PostMapping
    public ResponseEntity<Processed> postDangXuLi(@RequestBody Processed daHoanTat) {
		Processed savedDaHoanTat = repository.save(daHoanTat);
        return new ResponseEntity<>(savedDaHoanTat, HttpStatus.CREATED);
    }
	

}

