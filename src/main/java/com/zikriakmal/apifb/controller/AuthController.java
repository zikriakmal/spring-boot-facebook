package com.zikriakmal.apifb.controller;

import com.zikriakmal.apifb.dto.*;
import com.zikriakmal.apifb.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class AuthController {

    @Autowired
    AuthService authService;

    @PostMapping(
            path = "/api/v1/auth/login",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<LoginResponse> login(@RequestBody LoginRequest request){
        LoginResponse loginResponse = authService.login(request);
        return WebResponse.<LoginResponse>builder().data(loginResponse).build();
    }

    @PostMapping(
            path = "/api/v1/auth/register",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<RegisterResponse> register(@RequestBody RegisterRequest request){
       RegisterResponse registerResponse = authService.register(request);
       return WebResponse.<RegisterResponse>builder().data(registerResponse).build();
    }

}
