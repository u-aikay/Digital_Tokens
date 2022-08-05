package com.dtokens.digital_token.services;

import com.dtokens.digital_token.dtos.UserDto;
import com.dtokens.digital_token.utils.BaseResponse;

import javax.servlet.http.HttpServletRequest;

public interface UserService {
    BaseResponse<UserDto> createUserAccount(UserDto userRequest, HttpServletRequest request);

}
