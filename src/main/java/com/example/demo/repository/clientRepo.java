package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Client;

public interface ClientRepo extends CrudRepository<Client,Integer> {
    
}
