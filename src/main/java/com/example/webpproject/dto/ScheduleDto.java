package com.example.webpproject.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ScheduleDto {
    private String ownerName;
    private String petName;
    private LocalDate date;
    private String description;
    private String prescription;
    private Integer visitId;

}
