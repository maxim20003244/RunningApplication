package com.rungroup.web.runninapplication.impl;

import com.rungroup.web.runninapplication.dto.RegistrationDto;
import com.rungroup.web.runninapplication.models.Role;
import com.rungroup.web.runninapplication.models.UserEntity;
import com.rungroup.web.runninapplication.repository.RoleRepository;
import com.rungroup.web.runninapplication.repository.UserRepository;
import com.rungroup.web.runninapplication.service.UserService;

import java.util.ArrayList;
import java.util.Arrays;

public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public void saveUser(RegistrationDto registrationDto) {
        UserEntity user = new UserEntity();
        user.setUsername(registrationDto.getUserName());
        user.setEmail(registrationDto.getEmail());
        user.setPassword(registrationDto.getPassword());

        Role role = roleRepository.findByName("USER");
        user.setRoles(Arrays.asList(role));
        userRepository.save(user);

    }
}
