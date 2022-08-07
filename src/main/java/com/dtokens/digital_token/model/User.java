package com.dtokens.digital_token.model;

import com.dtokens.digital_token.enums.Role;
import com.sun.istack.NotNull;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @CreationTimestamp
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime modifyAt;
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    private String userName;
    @NotNull
    private String email;
    @NotNull
    private String phoneNumber;
    @NotNull
    private String password;
    @NotNull
    private String bvn;
    private String nin;
    private String eNairaAccountNumber;
    private Double eNairaAccountBalance;

    @Enumerated(EnumType.STRING)
    private Role role;
}
