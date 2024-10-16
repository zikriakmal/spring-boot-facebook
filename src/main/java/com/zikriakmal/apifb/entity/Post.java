package com.zikriakmal.apifb.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Duration;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String post;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Transient
    public String getFormattedUpdatedAtDifference() {
        LocalDateTime now = LocalDateTime.now();
        Duration duration = Duration.between(updatedAt, now);

        long hours = duration.toHours();
        long minutes = duration.minusHours(hours).toMinutes();
        long seconds = duration.minusHours(hours).minusMinutes(minutes).getSeconds();

        StringBuilder formattedDifference = new StringBuilder();
        if (hours > 0) {
            formattedDifference.append(hours).append(" hours, ");
        }
        if (minutes > 0) {
            formattedDifference.append(minutes).append(" minutes, ");
        }
        formattedDifference.append(seconds).append(" seconds ago");

        if(formattedDifference.toString().equals("0 seconds ago") || seconds == -1){
            return "Now";
        }else{
            return  formattedDifference.toString();
        }

    }

    @ManyToOne
    @JoinColumn(name = "user_id",nullable = false)
    private User user;


}
