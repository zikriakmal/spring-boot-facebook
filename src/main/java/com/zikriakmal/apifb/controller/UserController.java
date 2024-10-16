package com.zikriakmal.apifb.controller;

import com.zikriakmal.apifb.dto.UserResponse;
import com.zikriakmal.apifb.dto.WebResponse;
import com.zikriakmal.apifb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping(
            path = "/api/v1/users",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<List<UserResponse>> getUsers(UserResponse user) {
        List<UserResponse> userResponse = userService.getAll();
        return WebResponse.<List<UserResponse>>builder().data(userResponse).build();
    }

    @GetMapping(
            path = "/api/v1/current-user",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<UserResponse> getCurrent(UserResponse user){
        return WebResponse.<UserResponse>builder().data(user).build();
    }

}
