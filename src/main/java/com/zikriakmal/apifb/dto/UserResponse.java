package com.zikriakmal.apifb.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class UserResponse {

    private Integer id;

    private String email;

    private String username;

    private String name;

}
