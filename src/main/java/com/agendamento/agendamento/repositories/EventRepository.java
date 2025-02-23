package com.agendamento.agendamento.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.agendamento.agendamento.entity.EventEntity;

public interface EventRepository extends MongoRepository<EventEntity, String>{
}
