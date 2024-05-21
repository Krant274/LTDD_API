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

import com.example.cuahang.entity.Processing;
import com.example.cuahang.repository.ProcessingRepository;

@RestController
@RequestMapping(path = "/api/appfood/processing")
public class ProcessingController {
	
	@Autowired
	private ProcessingRepository repository;
	
	@GetMapping
	public ResponseEntity<?> getAllDonhang() {
		return ResponseEntity.ok().body(repository.findAll());
	}
	
	@PostMapping
    public ResponseEntity<Processing> postDangXuLi(@RequestBody Processing dangXuLi) {
        Processing savedDangXuLi = repository.save(dangXuLi);
        return new ResponseEntity<>(savedDangXuLi, HttpStatus.CREATED);
    }
	
	@DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") Integer id) {
        Optional<Processing> dangXuLiOptional = repository.findById(id);

        if (dangXuLiOptional.isPresent()) {
            repository.deleteById(id);
            return ResponseEntity.noContent().build(); // 204 No Content on success
        } else {
            return ResponseEntity.notFound().build(); // 404 Not Found if not found
        }
    }
	
}
