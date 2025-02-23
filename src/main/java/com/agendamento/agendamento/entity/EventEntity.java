package com.agendamento.agendamento.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "events")
public class EventEntity {
    @Id
    private String id;
    private String street;
    private String number;
    private String state;
    private String city;
    private String userId;
}
