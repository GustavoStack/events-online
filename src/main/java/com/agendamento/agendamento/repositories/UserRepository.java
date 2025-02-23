package com.agendamento.agendamento.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.agendamento.agendamento.entity.UserEntity;

public interface UserRepository extends MongoRepository<UserEntity, String>{
    public UserEntity findUserByEmail(String email);
}
