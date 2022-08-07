package com.dtokens.digital_token.dtos;

import lombok.*;

import javax.persistence.Column;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    @Column(name = "uid")
    private String bvn;
    private String title;
    private String firstName;
    private String middleName;
    private String lastName;
    private String userName;
    private String phone;
    private String emailId;
    private String postalCode;
    private String city;
    private String address;
    private String countryOfResidence;
    private String accountNumber;
    private String dateOfBirth;
    private String countryOfBirth;
    private String password;
}
