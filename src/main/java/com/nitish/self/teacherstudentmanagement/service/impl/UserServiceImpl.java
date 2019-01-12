package com.nitish.self.teacherstudentmanagement.service.impl;

import com.nitish.self.teacherstudentmanagement.dto.UserDTO;
import com.nitish.self.teacherstudentmanagement.exception.ResourceNotFoundException;
import com.nitish.self.teacherstudentmanagement.model.User;
import com.nitish.self.teacherstudentmanagement.repository.UserRepository;
import com.nitish.self.teacherstudentmanagement.service.UserService;
import com.nitish.self.teacherstudentmanagement.service.mapper.UserMapperService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapperService userMapperService;
    private final PasswordEncoder passwordEncoder;


    public UserServiceImpl(final UserRepository userRepository, final UserMapperService userMapperService, final PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.userMapperService = userMapperService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<User> getAllTeachers() {
        List<User> allTeachers = userRepository.findAllByRoles(2L);
        return allTeachers;
    }

    @Override
    public List<User> getAllStudents() {
        List<User> allStudents = userRepository.findAllByRoles(1L);
        return allStudents;
    }

    @Override
    public User getUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("user with id : " + id + " is not found!"));
        return user;
    }

    @Override
    public UserDTO updateUser(Long userId, UserDTO userDTO) {
        userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("user with id : " + userId + " is not found!"));
        User user = userMapperService.UserDTOToUser(userDTO);
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        user.setId(userId);
        UserDTO newUserDTO = userMapperService.UserToUserDTO(userRepository.save(user));
        return newUserDTO;
    }
}
