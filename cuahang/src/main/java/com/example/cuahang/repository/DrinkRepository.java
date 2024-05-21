package com.example.cuahang.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.cuahang.entity.Drink;

@Repository
public interface DrinkRepository  extends JpaRepository<Drink, Integer>{
	Optional<Drink> findByName(String name);
}
