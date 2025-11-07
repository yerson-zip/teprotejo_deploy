package com.teprotejo.dto;

import com.teprotejo.validation.PasswordMatches;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@PasswordMatches
public class RegisterRequest {

    @NotBlank
    private String name;

    @NotBlank
    private String last_name;

    @NotBlank
    @Pattern(regexp = "^\\+?[0-9]{10,15}$",
            message = "Número de celular inválido")
    private String tel;

    @Email(message = "formato de correo no valido")
    private String email;

    @NotBlank
    private String password;

    @NotBlank
    private String confirmPassword;

    @NotBlank
    private String direction;

    @NotBlank
    private String city;
}
