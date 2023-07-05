package com.rungroup.web.runninapplication.impl;

import com.rungroup.web.runninapplication.dto.RegistrationDto;
import com.rungroup.web.runninapplication.models.Role;
import com.rungroup.web.runninapplication.models.UserEntity;
import com.rungroup.web.runninapplication.repository.RoleRepository;
import com.rungroup.web.runninapplication.repository.UserRepository;
import com.rungroup.web.runninapplication.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void saveUser(RegistrationDto registrationDto) {
        UserEntity user = new UserEntity();
        user.setUsername(registrationDto.getUserName());
        user.setEmail(registrationDto.getEmail());
        user.setPassword(passwordEncoder.encode(registrationDto.getPassword()));

        Role role = roleRepository.findByName("USER");
        user.setRoles(Arrays.asList(role));
        userRepository.save(user);

    }

    @Override
    public UserEntity findByEmail(String email) {
      return   userRepository.findByEmail(email);

    }

    @Override
    public UserEntity findByUserName(String userName) {
        return userRepository.findByUsername(userName);
    }
}
