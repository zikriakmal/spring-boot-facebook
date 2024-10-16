package com.zikriakmal.apifb.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(unique = true, name="email")
    private String email;

    @Column(unique = true,name = "username")
    private String username;

    private String password;

    private String name;

    @OneToMany
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private List<Post> posts;

}

