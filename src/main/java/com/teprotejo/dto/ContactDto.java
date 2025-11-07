package com.teprotejo.dto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ContactDto {


    @NotBlank(message = "El nombre no puede estar vacío")
    private String name;

    @NotBlank(message = "El teléfono no puede estar vacío")
    private String telefone;


    private String relationship;

    @NotNull(message = "El ID del usuario es obligatorio")
    private Long userId;

}
