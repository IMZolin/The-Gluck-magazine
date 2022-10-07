package com.example.thegluck.repos;
import com.example.thegluck.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
public interface UserRepo extends JpaRepository<User, Long> {
    User findByUsername(String username);
    User findByEmail(String email);
}
