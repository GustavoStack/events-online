package com.agendamento.agendamento.dtos;

import java.time.LocalDateTime;

public record EventScheduleDTO(String eventId, String userId, String ownerId , LocalDateTime eventTime) {

}
