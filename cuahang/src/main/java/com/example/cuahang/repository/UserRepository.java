package com.example.cuahang.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cuahang.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{
}

