package com.zikriakmal.apifb.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostResponse {

    private Integer id;

    private String post;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private String FormattedUpdatedAtDifference;

    private UserResponse user;
}
