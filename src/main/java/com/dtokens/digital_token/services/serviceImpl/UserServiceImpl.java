package com.dtokens.digital_token.services.serviceImpl;

import com.dtokens.digital_token.dtos.UserDto;
import com.dtokens.digital_token.repository.UserRepository;
import com.dtokens.digital_token.services.UserService;
import com.dtokens.digital_token.utils.BaseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import javax.servlet.http.HttpServletRequest;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    @Override
    public BaseResponse<UserDto> createUserAccount(UserDto userDto, HttpServletRequest request) {
        if (userRepository.existsByEmail(userDto.getEmail())){
            return new BaseResponse<>(HttpStatus.BAD_REQUEST, "User already exist with this email", null);
        }
        //CREATE WALLET

        return null;
    }
}
