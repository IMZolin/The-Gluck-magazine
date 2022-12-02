package com.example.thegluck.repos;
import com.example.thegluck.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<UserEntity, Long> {
    public UserEntity findByEmail(String email);
    public UserEntity findByUsername(String username);
    public UserEntity findByUsername(Long id);
}
