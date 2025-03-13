package com.agendamento.agendamento.dtos;

import java.math.BigDecimal;

public record EventDTO(String street, String number, String imageUrl, String state, BigDecimal price, String city, String userId, Boolean isSchedule) {
}
