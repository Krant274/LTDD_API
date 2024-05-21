package com.example.cuahang.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.cuahang.entity.Processed;


@Repository
public interface ProcessedRepository  extends JpaRepository<Processed, Integer>{
	Optional<Processed> findByDonhang(String Donhang);
}

