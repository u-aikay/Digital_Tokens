package com.dtokens.digital_token.services;

import com.dtokens.digital_token.model.fxWallet;

public interface fxWalletService {
    fxWallet createFxWallet(fxWallet fxWallet);
    fxWallet getFxWallet(Long id);
    fxWallet fundFxWallet(fxWallet fxWallet);
}
