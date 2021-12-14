package com.example.webpproject.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ReservationDto {
    private String name;
    private String petName;
    private LocalDate date;
    private String description;
}
