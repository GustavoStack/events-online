package com.agendamento.agendamento.entity;

import java.math.BigDecimal;

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
    private String imageUrl;
    private String street;
    private String number;
    private BigDecimal price;
    private String state;
    private String city;
    private String userId;
    private Boolean isSchedule;
}
