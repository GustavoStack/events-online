package com.agendamento.agendamento.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agendamento.agendamento.dtos.EventDTO;
import com.agendamento.agendamento.entity.EventEntity;
import com.agendamento.agendamento.services.EventService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
@RequestMapping("/events")
public class EventController {
    @Autowired
    private EventService eventService;

    @PostMapping
    public ResponseEntity<EventEntity> createEvent(@RequestBody EventDTO eventDTO) {
        EventEntity eventEntity = this.eventService.createEvent(eventDTO);
        return new ResponseEntity<>(eventEntity, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<EventEntity>> getEvents() {
        List<EventEntity> events = this.eventService.getAllEvents();
        return new ResponseEntity<>(events, HttpStatus.OK);
    }
    
}
