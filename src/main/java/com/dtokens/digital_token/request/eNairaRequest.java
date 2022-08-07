package com.dtokens.digital_token.request;


import lombok.*;

import javax.persistence.Column;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class eNairaRequest {

        private String channel_code;
        @Column(name = "uid")
        private String bvn;
        private String uidType;
        private String reference;
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
        private String tier;
        private String accountNumber;
        private String dateOfBirth;
        private String countryOfBirth;
        private String password;
        private String remarks;
        private String referralCode;
}
