package com.dtokens.digital_token.services.serviceImpl;

import com.dtokens.digital_token.config.security.JwtTokenProvider;
import com.dtokens.digital_token.request.LoginRequest;
import com.dtokens.digital_token.response.JwtAuthResponse;
import com.dtokens.digital_token.services.LoginService;
import com.dtokens.digital_token.utils.BaseResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import javax.servlet.http.HttpServletResponse;

@Service
@RequiredArgsConstructor
@Slf4j
public class LoginServiceImpl implements LoginService {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;
    private final HttpServletResponse httpServletResponse;

    @Override
    public BaseResponse<JwtAuthResponse> login(LoginRequest loginRequest) throws Exception {
        String token;
        String message = "Login Successful";
        String email = loginRequest.getEmail();
        String password = loginRequest.getPassword();

        log.info("Initiating authentication for " + loginRequest.getEmail());
        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(email, password);
        Authentication authenticatedToken = authenticationManager.authenticate(authToken);

        if (!authenticatedToken.isAuthenticated()) {
            log.error(email + " Inputted an incorrect password!");
            throw new Exception("incorrect user credentials");
        }
        SecurityContextHolder.getContext().setAuthentication(authenticatedToken);
        token = jwtTokenProvider.generateToken(authenticatedToken);
        httpServletResponse.setHeader("Authorization", token);

        log.info("Successfully logged in {}!", loginRequest.getEmail());
        return new BaseResponse<>(HttpStatus.OK, message, new JwtAuthResponse(token));

//        try{
//            log.info("Initiating authentication for " + loginRequest.getEmail());
//            Authentication auth =  new UsernamePasswordAuthenticationToken(
//                    loginRequest.getEmail(),loginRequest.getPassword());
//
//            authentication = authenticationManager.authenticate(auth);
//            SecurityContextHolder.getContext().setAuthentication(authentication);
//            token = jwtTokenProvider.generateToken(authentication);
//            httpServletResponse.setHeader("Authorization", token);
//        }
//        catch (BadCredentialsException ex){
//            throw new Exception("incorrect user credentials", ex);
//        }
//        log.info("Successfully logged in {}!", loginRequest.getEmail());
//        return new BaseResponse<>(HttpStatus.OK, message, new JwtAuthResponse(token));
    }


    @Override
    public BaseResponse<?> logout() {
        return null;
    }
}
