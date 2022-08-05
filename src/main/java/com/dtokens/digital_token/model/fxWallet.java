package com.dtokens.digital_token.model;


import lombok.*;
import org.hibernate.annotations.*;
import javax.persistence.*;
import javax.persistence.Entity;
import java.time.LocalDateTime;

@Entity
@Data
@Getter
@Setter
public class fxWallet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @CreationTimestamp
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime modifyAt;
    private String accountId;
    private Boolean balance;
    @OneToOne
    private User user;
}
