package com.dtokens.digital_token.services.serviceImpl;

import com.dtokens.digital_token.dtos.UserDto;
import com.dtokens.digital_token.enums.Role;
import com.dtokens.digital_token.model.User;
import com.dtokens.digital_token.repository.UserRepository;
import com.dtokens.digital_token.response.UserResponse;
import com.dtokens.digital_token.response.eNairaWalletResponse;
import com.dtokens.digital_token.services.UserService;
import com.dtokens.digital_token.utils.BaseResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;


@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final eNairaWalletServiceImpl eNairaWalletService;


    @Override
    public BaseResponse<UserResponse> createUserAccount(UserDto userDto, HttpServletRequest request) throws IOException, KeyStoreException, NoSuchAlgorithmException, KeyManagementException {
        if (userRepository.findUserByEmail(userDto.getEmailId()) != null) {
            return new BaseResponse<>(HttpStatus.BAD_REQUEST, "User already exist with this email", null);
        }

        //CREATE WALLET & USER
         eNairaWalletResponse body = eNairaWalletService.createeNairaWallet(userDto);

        //CREATE USER
        User newUser = User.builder().eNairaAccountNumber(body.getResponse_data().getNuban())
                .firstName(userDto.getFirstName()).lastName(userDto.getLastName())
                .userName(userDto.getUserName()).bvn(userDto.getBvn()).email(userDto.getEmailId())
                .phoneNumber(userDto.getPhone()).password(passwordEncoder.encode(userDto.getPassword()))
                .eNairaAccountBalance(0.00)
                .role(Role.CUSTOMER).build();

        UserResponse response = userResponse(newUser);
        log.info(body.getResponse_data().getNuban());
        log.info(body.getResponse_data().getNuban());
        log.info(body.getResponse_data().getNuban());
        log.info(body.getResponse_data().getNuban());
        userRepository.save(newUser);
        return new BaseResponse<>(HttpStatus.OK, "User created successfully", response);
    }

    private UserResponse userResponse(User user) {
        return UserResponse.builder().id(user.getId()).firstName(user.getFirstName()).lastName(user.getLastName())
                .userName(user.getUserName()).bvn(user.getBvn()).email(user.getEmail())
                .accountNumber(user.getENairaAccountNumber()).phoneNumber(user.getPhoneNumber())
                .accountBalance(user.getENairaAccountBalance()).build();
    }
}
