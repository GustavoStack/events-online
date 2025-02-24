package com.agendamento.agendamento.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agendamento.agendamento.dtos.EventScheduleDTO;
import com.agendamento.agendamento.entity.EventScheduleEntity;
import com.agendamento.agendamento.entity.EventEntity;
import com.agendamento.agendamento.entity.UserEntity;
import com.agendamento.agendamento.repositories.EventRepository;
import com.agendamento.agendamento.repositories.EventScheduleRepository;

@Service
public class EventScheduleService {
    @Autowired
    private EventService eventService;
    @Autowired
    private UserService userService;
    @Autowired
    private EventScheduleRepository eventScheduleRepository;
    @Autowired
    private EventRepository eventRepository;

    public EventScheduleEntity scheduleEvent(EventScheduleDTO eventAgendaDTO){
        EventEntity event = this.eventService.findEventById(eventAgendaDTO.eventId());
        if(event == null){
            throw new IllegalArgumentException("Event not found");
        }
        if(event.getIsSchedule() == true){
            throw new IllegalArgumentException("Event is already scheduled");
        }
        validateUser(eventAgendaDTO.userId());
        validateUser(eventAgendaDTO.ownerId());

        EventScheduleEntity eventSchedule = new EventScheduleEntity();
        eventSchedule.setEventId(eventAgendaDTO.eventId());
        eventSchedule.setUserId(eventAgendaDTO.userId());
        eventSchedule.setOwnerId(eventAgendaDTO.ownerId());
        eventSchedule.setRegisterTime(LocalDateTime.now());
        eventSchedule.setEventTime(eventAgendaDTO.eventTime());
        event.setIsSchedule(true);
        eventRepository.save(event);
        return this.eventScheduleRepository.save(eventSchedule);
    }
    public void validateUser(String id){
        UserEntity user = this.userService.getUserById(id);
        if(user == null){
            throw new IllegalArgumentException("User not found");
        }
    }
    public EventScheduleEntity findSchedule(String id){
        return eventScheduleRepository.findById(id).orElse(null);
    }
    public List<EventScheduleEntity> findAllSchedule(){
        return this.eventScheduleRepository.findAll();
    }
}
