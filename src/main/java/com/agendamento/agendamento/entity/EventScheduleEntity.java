package com.agendamento.agendamento.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "schedule_events")
public class EventScheduleEntity {
    @Id
    private String id;
    private String eventId;
    private String userId;
    private String ownerId;
    private LocalDateTime registerTime;
    private LocalDateTime eventTime;
}
