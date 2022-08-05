package com.dtokens.digital_token.dtos;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@Builder
public class UserDto {
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String password;
}
