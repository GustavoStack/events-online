package com.agendamento.agendamento.entity.exceptions;

public class EventScheduleException extends RuntimeException{
    public EventScheduleException(){
        super("Evento já agendado.");
    }
}


