package com.rungroup.web.runninapplication.service;

import com.rungroup.web.runninapplication.dto.RegistrationDto;
import com.rungroup.web.runninapplication.models.UserEntity;
import org.springframework.stereotype.Service;


public interface UserService {
    void saveUser(RegistrationDto registrationDto);

    UserEntity findByEmail(String email);

    UserEntity findByUserName(String userName);
}
