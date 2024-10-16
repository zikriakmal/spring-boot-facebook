package com.zikriakmal.apifb.dto;

import com.zikriakmal.apifb.validation.UniqueEmail;
import com.zikriakmal.apifb.validation.UniqueUsernameValInt;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegisterRequest {


    @NotBlank
    @Size(max= 100)
    @Email()
    @UniqueEmail(message ="has been taken")
    private  String email;

    @NotBlank
    @Size(max = 100)
    @UniqueUsernameValInt(message = "has been taken")
    private String username;

    @NotBlank
    @Size(max = 100)
    private String name;

    @NotBlank
    @Size(max = 100)
    private String password;

}