package com.dtokens.digital_token.services.serviceImpl;

import com.dtokens.digital_token.config.RestTemplateConfig;
import com.dtokens.digital_token.dtos.UserDto;
import com.dtokens.digital_token.model.eNairaWallet;
import com.dtokens.digital_token.request.eNairaRequest;
import com.dtokens.digital_token.response.eNairaWalletResponse;
import com.dtokens.digital_token.services.eNairaWalletService;
import com.dtokens.digital_token.utils.BaseResponse;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
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

        MediaType mediaType = MediaType.parseMediaType("text/plain");
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
    public BaseResponse<String> fundeNairaWallet(eNairaWallet eNairaWallet) throws IOException {

        OkHttpClient client = new OkHttpClient();
        String REPLACE_BODY = "{\n" +
                "  \"ConsumerId\": \"" + eNairaWallet.toString() + "\",\n" +
                "  \"Amount\": \"" + eNairaWallet + "\"\n" +
                "}";
        MediaType mediaType = MediaType.parseMediaType("text/plain");
        RequestBody body = RequestBody.create(REPLACE_BODY.getBytes(StandardCharsets.UTF_8));
        Request request = new Request.Builder()
                .url("https://rgw.k8s.apis.ng/centric-platforms/uat/CreateDeposit")
                .post(RequestBody.Companion.create(REPLACE_BODY.getBytes(StandardCharsets.UTF_8)))
                .addHeader("ClientId", "clientId")
                .addHeader("content-type", "application/json")
                .addHeader("accept", "application/json")
                .build();

        Response response = client.newCall(request).execute();
        return  null;
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

