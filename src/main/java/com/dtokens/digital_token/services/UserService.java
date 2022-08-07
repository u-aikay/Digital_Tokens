package com.dtokens.digital_token.services;

import com.dtokens.digital_token.dtos.UserDto;
import com.dtokens.digital_token.request.eNairaRequest;
import com.dtokens.digital_token.response.UserResponse;
import com.dtokens.digital_token.response.eNairaWalletResponse;
import com.dtokens.digital_token.utils.BaseResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;

public interface UserService {
    BaseResponse<UserResponse> createUserAccount(UserDto userDto, HttpServletRequest request) throws IOException, KeyStoreException, NoSuchAlgorithmException, KeyManagementException;

}
