package com.dtokens.digital_token.services.serviceImpl;

import com.dtokens.digital_token.config.RestTemplateConfig;
import com.dtokens.digital_token.dtos.UserDto;
import com.dtokens.digital_token.model.eNairaWallet;
import com.dtokens.digital_token.request.eNairaRequest;
import com.dtokens.digital_token.response.eNairaWalletResponse;
import com.dtokens.digital_token.services.eNairaWalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.Collections;

@Service
public class eNairaWalletServiceImpl implements eNairaWalletService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    RestTemplateConfig restTemplateConfig;

//    @Value("461f3e413bfc4a3027370ecbf03719d2")
    private final String CLIENT_ID = "461f3e413bfc4a3027370ecbf03719d2";

    public eNairaWalletServiceImpl(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public eNairaWalletResponse createeNairaWallet(UserDto userDto) throws IOException, KeyStoreException,
            NoSuchAlgorithmException, KeyManagementException {

        String CREATE_eNAIRA_WALLET_API = "https://rgw.k8s.apis.ng/centric-platforms/uat/enaira-user/CreateConsumerV2";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.set("ClientId", CLIENT_ID);

        eNairaRequest payload = generatePayload(userDto);
        HttpEntity<eNairaRequest> request = new HttpEntity<>(payload, headers);

        eNairaWalletResponse body = restTemplateConfig.restTemplate().exchange(
                CREATE_eNAIRA_WALLET_API,
                HttpMethod.POST,
                request,
                eNairaWalletResponse.class).getBody();
        assert body != null;

        return body;
    }

    @Override
    public eNairaWallet geteNairaWallet(Long id) {
        return null;
    }

    @Override
    public eNairaWallet fundeNairaWallet(eNairaWallet eNairaWallet) {
        return null;
    }

    private eNairaRequest generatePayload(UserDto userDto) {

        return eNairaRequest.builder()
                .channel_code("APISNG").bvn(userDto.getBvn()).uidType("BVN")
                .reference("NXG3547585HGTKJHGO").title(userDto.getTitle())
                .firstName(userDto.getFirstName()).middleName(userDto.getMiddleName())
                .lastName(userDto.getLastName()).userName(userDto.getUserName())
                .phone(userDto.getPhone()).emailId(userDto.getEmailId()).postalCode(userDto.getPostalCode())
                .city(userDto.getCity()).address(userDto.getAddress()).address(userDto.getAddress())
                .countryOfResidence(userDto.getCountryOfResidence()).tier("2")
                .accountNumber(userDto.getAccountNumber()).dateOfBirth(userDto.getDateOfBirth())
                .countryOfBirth(userDto.getCountryOfBirth()).password(userDto.getPassword())
                .remarks("passed").referralCode("@imbah.01").build();
    }
}

