package com.dtokens.digital_token.services;

import com.dtokens.digital_token.dtos.UserDto;
import com.dtokens.digital_token.model.eNairaWallet;
import com.dtokens.digital_token.response.eNairaWalletResponse;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;

public interface eNairaWalletService {

    eNairaWalletResponse createeNairaWallet(UserDto userDto) throws IOException, KeyStoreException, NoSuchAlgorithmException, KeyManagementException;
    eNairaWallet geteNairaWallet(Long id);
    eNairaWallet fundeNairaWallet(eNairaWallet eNairaWallet);

}
