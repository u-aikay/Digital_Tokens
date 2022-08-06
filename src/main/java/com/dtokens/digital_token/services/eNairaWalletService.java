package com.dtokens.digital_token.services;

import com.dtokens.digital_token.model.eNairaWallet;

public interface eNairaWalletService {
    eNairaWallet createeNairaWallet(eNairaWallet eNairaWallet);
    eNairaWallet geteNairaWallet(Long id);
    eNairaWallet fundeNairaWallet(eNairaWallet eNairaWallet);

}
