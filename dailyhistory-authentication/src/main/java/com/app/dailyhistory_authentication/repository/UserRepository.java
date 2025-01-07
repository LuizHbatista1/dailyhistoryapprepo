package com.app.dailyhistory_authentication.repository;

import com.app.dailyhistory_authentication.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);


}
