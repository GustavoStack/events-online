package com.agendamento.agendamento.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.agendamento.agendamento.entity.EventScheduleEntity;

public interface EventScheduleRepository extends MongoRepository<EventScheduleEntity, String>{

}
