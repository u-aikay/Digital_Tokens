package com.dtokens.digital_token.controllers;

import com.dtokens.digital_token.dtos.UserDto;
import com.dtokens.digital_token.request.LoginRequest;
import com.dtokens.digital_token.response.JwtAuthResponse;
import com.dtokens.digital_token.response.UserResponse;
import com.dtokens.digital_token.services.LoginService;
import com.dtokens.digital_token.services.UserService;
import com.dtokens.digital_token.utils.BaseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final LoginService loginService;

    @PostMapping("/sign_up")
    public BaseResponse<UserResponse> createUser(@RequestBody UserDto userDto, HttpServletRequest request) throws IOException, KeyStoreException, NoSuchAlgorithmException, KeyManagementException {
            return userService.createUserAccount(userDto, request);
    }

    @PostMapping("/login")
    public BaseResponse<JwtAuthResponse> login(@RequestBody LoginRequest loginRequest) throws Exception {
        return loginService.login(loginRequest);
    }

}
