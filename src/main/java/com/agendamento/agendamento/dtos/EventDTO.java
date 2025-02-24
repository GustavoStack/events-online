package com.agendamento.agendamento.dtos;


public record EventDTO(String street, String number, String state, String city, String userId, Boolean isSchedule) {
}
