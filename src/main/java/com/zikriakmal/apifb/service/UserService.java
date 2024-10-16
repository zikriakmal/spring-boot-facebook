package com.zikriakmal.apifb.service;

import com.zikriakmal.apifb.dto.UserResponse;
import com.zikriakmal.apifb.entity.User;
import com.zikriakmal.apifb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserResponse> getAll(){
        List<User> users = userRepository.findAll();

        return users.stream()
                .map(this::convertToUserResponse)
                .collect(Collectors.toList());
    }

    public UserResponse getCurrentUser(){
        return UserResponse.builder().username("username").name("name").build();
    }

    public UserResponse convertToUserResponse(User user) {
        // Assuming User entity has fields username and name
        return UserResponse.builder()
                .id(user.getId())
                .username(user.getUsername())
                .name(user.getName())
                .email(user.getEmail())
                .build();
    }

}
