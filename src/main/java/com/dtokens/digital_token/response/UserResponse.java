package com.dtokens.digital_token.response;


import com.dtokens.digital_token.model.User;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserResponse {
    private Long id;
    private String firstName;
    private String lastName;
    private String userName;
    private String email;
    private String phoneNumber;
    private String accountNumber;
    private Double accountBalance;
    private String bvn;
    private String token;
    private boolean status;

    public UserResponse(User user) {
    }
}

