package com.dtokens.digital_token.model;

import com.sun.istack.NotNull;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

//@Entity
//@Data
//@Getter
//@Setter
//@Builder
//@NoArgsConstructor
//@AllArgsConstructor
public class eNairaWallet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @CreationTimestamp
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private String channel_code;
    private Double account_balance;
    @NotNull
    private String uid;
    private String uidType;
    private String reference;
    @NotNull
    private String title;
    @NotNull
    private String firstName;
    @NotNull
    private String middleName;
    @NotNull
    private String lastName;
    @NotNull
    private String userName;
    @NotNull
    private String phone;
    @NotNull
    @Column(unique = true)
    private String emailId;
    @NotNull
    private String postalCode;
    @NotNull
    private String city;
    @NotNull
    private String address;
    @NotNull
    private String countryOfResidence;
    private String tier;
    @NotNull
    private String accountNumber;
    @NotNull
    private String dateOfBirth;
    @NotNull
    private String countryOfBirth;
    @NotNull
    @Size(min = 12, message = "Account should have at least 12 number")
    private String password;
    private String remarks;
    private String referralCode;
    @OneToOne(cascade = CascadeType.ALL)
    private User user;
}
