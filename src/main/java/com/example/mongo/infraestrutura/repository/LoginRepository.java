package com.example.mongo.infraestrutura.repository;

import com.example.mongo.domain.model.Login;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LoginRepository extends MongoRepository<Login, String> {
}