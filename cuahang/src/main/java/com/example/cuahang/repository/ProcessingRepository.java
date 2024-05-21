package com.example.cuahang.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.cuahang.entity.Processing;


@Repository
public interface ProcessingRepository  extends JpaRepository<Processing, Integer>{
	Optional<Processing> findByDonhang(String Donhang);
}

