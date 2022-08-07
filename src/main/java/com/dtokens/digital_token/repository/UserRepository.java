package com.dtokens.digital_token.repository;

import com.dtokens.digital_token.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    User findUserByEmail(String email);
    boolean existsByEmail(String email);
}

