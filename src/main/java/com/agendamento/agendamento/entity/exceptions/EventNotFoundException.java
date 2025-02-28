package com.agendamento.agendamento.entity.exceptions;

public class EventNotFoundException extends RuntimeException{
    public EventNotFoundException(){
        super("Evento não encontrado.");
    }
}
