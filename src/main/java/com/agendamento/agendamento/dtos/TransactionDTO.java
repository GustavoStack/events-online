package com.agendamento.agendamento.dtos;

import java.math.BigDecimal;

public record TransactionDTO(BigDecimal value, String senderId, String receiverId, String eventId) {

}
