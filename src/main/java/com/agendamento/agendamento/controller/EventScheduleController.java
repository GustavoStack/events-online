package com.agendamento.agendamento.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agendamento.agendamento.dtos.EventScheduleDTO;
import com.agendamento.agendamento.entity.EventScheduleEntity;
import com.agendamento.agendamento.services.EventScheduleService;

@RestController
@RequestMapping("/scheduleEvents")
public class EventScheduleController {
    @Autowired
    private EventScheduleService eventScheduleService;

    @PostMapping
    public ResponseEntity<EventScheduleEntity> scheduleEvent(@RequestBody EventScheduleDTO eventAgenda){
        EventScheduleEntity eventAgendaEntity = this.eventScheduleService.scheduleEvent(eventAgenda);
        return new ResponseEntity<>(eventAgendaEntity, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<EventScheduleEntity>> getScheduleEvents(){
        List<EventScheduleEntity> events = this.eventScheduleService.findAllSchedule();
        return new ResponseEntity<>(events, HttpStatus.OK);
    }
}
