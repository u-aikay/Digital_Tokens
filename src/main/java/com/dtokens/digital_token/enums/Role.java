package com.dtokens.digital_token.enums;

public enum Role {
    CUSTOMER("Customer"),
    ADMIN("Admin");

    private final String role;

    Role(String role) {
        this.role = role;
    }
}
