package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.User;

public interface userRepo extends CrudRepository<User,Integer> {

    User findByUsername(String username);
    
}
