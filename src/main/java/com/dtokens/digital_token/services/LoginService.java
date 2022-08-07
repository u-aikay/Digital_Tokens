package com.dtokens.digital_token.services;

import com.dtokens.digital_token.request.LoginRequest;
import com.dtokens.digital_token.response.JwtAuthResponse;
import com.dtokens.digital_token.utils.BaseResponse;

public interface LoginService {
    BaseResponse<JwtAuthResponse> login(LoginRequest loginRequest) throws Exception;
    BaseResponse<?> logout();
}
