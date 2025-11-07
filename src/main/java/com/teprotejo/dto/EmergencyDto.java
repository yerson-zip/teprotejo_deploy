package com.teprotejo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class EmergencyDto {




    @NotNull
    private Long userId;



    @NotNull
    private double  latitude;

    @NotNull
    private double longitude;

    @NotBlank(message = "la ciudad no puede ser nula")
    private String city;

    @NotNull
    private LocalDateTime dateTime;



}
