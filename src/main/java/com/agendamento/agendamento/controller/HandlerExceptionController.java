package com.agendamento.agendamento.controller;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.agendamento.agendamento.dtos.ExceptionDTO;
import com.agendamento.agendamento.entity.exceptions.EventNotFoundException;
import com.agendamento.agendamento.entity.exceptions.InvalideUserTypeException;
import com.agendamento.agendamento.entity.exceptions.TransactionDontAuthorizedException;
import com.agendamento.agendamento.entity.exceptions.UserNotFoundException;

@RestControllerAdvice
public class HandlerExceptionController {
    //usuaio ja existente
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ExceptionDTO> handleDuplicateEntry(DataIntegrityViolationException exception) {
        ExceptionDTO exceptionDTO = new ExceptionDTO("Usuário já cadastrado!", HttpStatus.BAD_REQUEST.value());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exceptionDTO);
    }
    //errso relacionados a tipo de usuario
    @ExceptionHandler(InvalideUserTypeException.class)
    public ResponseEntity<ExceptionDTO> handleInvalideUserTypeException(Exception exception) {
        ExceptionDTO exceptionDTO = new ExceptionDTO(exception.getMessage(), HttpStatus.BAD_REQUEST.value());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exceptionDTO);
    }
    //erros genericos
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionDTO> handleGeneralException(Exception exception) {
        ExceptionDTO exceptionDTO = new ExceptionDTO(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exceptionDTO);
    }   
    //erros relacionados a transações invalidadas
    @ExceptionHandler(TransactionDontAuthorizedException.class)
    public ResponseEntity<ExceptionDTO> handleTransactionDontAuthorized(Exception exception){
        ExceptionDTO exceptionDTO = new ExceptionDTO(exception.getMessage(), HttpStatus.FORBIDDEN.value());
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(exceptionDTO);
    }
    //evento nao encontrado
    @ExceptionHandler(EventNotFoundException.class)
    public ResponseEntity<ExceptionDTO> handleEventNotFound(Exception exception){
        ExceptionDTO exceptionDTO = new ExceptionDTO(exception.getMessage(), HttpStatus.NOT_FOUND.value());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exceptionDTO);
    }
    //usuario nao encontrado
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ExceptionDTO> handleUserNotFound(Exception exception){
        ExceptionDTO exceptionDTO = new ExceptionDTO(exception.getMessage(), HttpStatus.NOT_FOUND.value());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exceptionDTO);
    }
}