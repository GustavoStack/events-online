package com.agendamento.agendamento.entity.exceptions;

public class InvalideUserTypeException extends RuntimeException {
    public InvalideUserTypeException() {
        super("Usuario invalido!");
    }

}
