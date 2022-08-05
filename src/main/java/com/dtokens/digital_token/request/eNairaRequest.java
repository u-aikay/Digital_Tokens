package com.dtokens.digital_token.request;


import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class eNairaRequest {

        private String channel_code;
        private String customer_tier;
        private String reference;
        private String account_no;
        private String bvn;
        private String password;
        private String nin;

}


//NEXTGEN
//2
//NXG34567898FGHJJB1
//0689658501
//22152793496
//Password10$$
