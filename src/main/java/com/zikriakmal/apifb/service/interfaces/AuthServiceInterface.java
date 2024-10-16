package com.zikriakmal.apifb.service.interfaces;

import com.zikriakmal.apifb.dto.LoginRequest;
import com.zikriakmal.apifb.dto.LoginResponse;
import com.zikriakmal.apifb.dto.RegisterRequest;
import com.zikriakmal.apifb.dto.RegisterResponse;

public interface AuthServiceInterface {

    LoginResponse login(LoginRequest loginRequest);
    RegisterResponse register(RegisterRequest registerRequest);
}
