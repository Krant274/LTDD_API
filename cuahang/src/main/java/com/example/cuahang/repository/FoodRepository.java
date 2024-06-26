package com.example.cuahang.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.cuahang.entity.Food;


@Repository
public interface FoodRepository  extends JpaRepository<Food, Integer>{
	Optional<Food> findByName(String name);
}
