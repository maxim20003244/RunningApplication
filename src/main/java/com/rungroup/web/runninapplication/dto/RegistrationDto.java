package com.rungroup.web.runninapplication.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class RegistrationDto {
    private Long id;
    @NotEmpty
    private String userName;
    @NotEmpty
    @Email(message = "Enter a valid email")
    private String email;

    @NotEmpty
    @Size(min = 5 , message = "Password should to be min 5 char")
    private String password;
}
