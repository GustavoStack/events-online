package com.agendamento.agendamento.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agendamento.agendamento.dtos.EventDTO;
import com.agendamento.agendamento.entity.EventEntity;
import com.agendamento.agendamento.entity.UserEntity;
import com.agendamento.agendamento.repositories.EventRepository;

@Service
public class EventService {
    @Autowired
    private EventRepository eventRepository;
    @Autowired
    private UserService userService;

    public EventEntity saveEvent(EventEntity entity) {
        return eventRepository.save(entity);
    }

    public EventEntity findEventById(String id) {
        return eventRepository.findById(id).orElse(null);
    }

    public List<EventEntity> getAllEvents(){
        return this.eventRepository.findAll();
    }

    public void deleteById(String id) {
        eventRepository.deleteById(id);
    }

    public EventEntity createEvent(EventDTO eventDTO) {
        if(eventDTO == null){
            throw new IllegalArgumentException("EventDTO cannot be null");
        }
        UserEntity user = this.userService.getUserById(eventDTO.userId());
        userService.validateUserForEvent(user);

        EventEntity eventEntity = new EventEntity();
        eventEntity.setNumber(eventDTO.number());
        eventEntity.setStreet(eventDTO.street());
        eventEntity.setState(eventDTO.state());
        eventEntity.setCity(eventDTO.city());
        eventEntity.setUserId(user.getId());
        eventEntity.setIsSchedule(false);
        return this.saveEvent(eventEntity);
    }
}
