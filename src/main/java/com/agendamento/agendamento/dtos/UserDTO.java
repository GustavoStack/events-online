package com.agendamento.agendamento.dtos;

import java.math.BigDecimal;

import com.agendamento.agendamento.entity.UserType;

public record UserDTO(String firstName,String lastName, String email, BigDecimal balance, UserType userType) {
}
