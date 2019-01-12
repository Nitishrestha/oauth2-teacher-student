package com.nitish.self.teacherstudentmanagement.service.impl;

import com.nitish.self.teacherstudentmanagement.dto.ApiResponse;
import com.nitish.self.teacherstudentmanagement.dto.UserDTO;
import com.nitish.self.teacherstudentmanagement.exception.ResourceNotFoundException;
import com.nitish.self.teacherstudentmanagement.model.Role;
import com.nitish.self.teacherstudentmanagement.model.RoleName;
import com.nitish.self.teacherstudentmanagement.model.User;
import com.nitish.self.teacherstudentmanagement.repository.RoleRepository;
import com.nitish.self.teacherstudentmanagement.repository.UserRepository;
import com.nitish.self.teacherstudentmanagement.service.AuthService;
import com.nitish.self.teacherstudentmanagement.service.mapper.UserMapperService;
import com.nitish.self.teacherstudentmanagement.utils.RoleUtil;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.Optional;

@Service
@Transactional
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final RoleRepository roleRepository;

    private final UserMapperService userMapperService;

    public AuthServiceImpl(final UserRepository userRepository, final PasswordEncoder passwordEncoder, final RoleRepository roleRepository, final UserMapperService userMapperService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
        this.userMapperService = userMapperService;
    }

    @Override
    public ApiResponse register(UserDTO userDTO) {
        Optional<User> byUsername = userRepository.findByUsername(userDTO.getUsername());
        if (byUsername.isPresent()) {
            new ApiResponse(false, "username already in use!");
        }
        Optional<User> byEmail = userRepository.findByEmail(userDTO.getEmail());
        if (byEmail.isPresent()) {
            new ApiResponse(false, "Email Address already in use!");
        }
        // Creating user's account
        User user = userMapperService.UserDTOToUser(userDTO);
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        String newRole = userDTO.getRole().toUpperCase();
        if (RoleUtil.checkRole(newRole)) {
            if (newRole.equalsIgnoreCase("ROLE_ADMIN")) {
                throw new RuntimeException("Unauthorized...You cannot set your role to super admin...");
            }
        }
        Role role = roleRepository.findByName(RoleName.valueOf(newRole)).orElseThrow(() -> new ResourceNotFoundException(newRole + " not found!"));
        user.setRoles(Collections.singleton(role));
        userRepository.save(user);
        return new ApiResponse(true, "User registered successfully");
    }
}