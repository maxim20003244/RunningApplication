package com.rungroup.web.runninapplication.repository;

import com.rungroup.web.runninapplication.models.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findByEmail(String email);
    UserEntity findByUsername(String useName);

    UserEntity findFirstByUsername(String username);
}
