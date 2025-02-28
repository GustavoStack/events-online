package com.agendamento.agendamento.entity.exceptions;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(){
        super("Usuário não encontrado.");
    }
}
