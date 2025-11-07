package com.teprotejo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;


@Data
public class CAIDto {


    @NotBlank(message = "el nombre de la estación no puede estar vacío")
    private String station_name;

    @NotBlank
    @Pattern(regexp = "^\\+?[0-9]{10,15}$",
            message = "Número de celular inválido")
    private String telephone;


    @NotNull
    private double latitude;

    @NotNull
    private double longitude;

    @NotBlank
    private String city;

}
