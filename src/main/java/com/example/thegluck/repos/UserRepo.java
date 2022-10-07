package com.example.thegluck.repos;
import com.example.thegluck.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByUsername(String username);
    //select one * from user u where u.email = :email
    Optional<User> findByEmail(String email);
}
