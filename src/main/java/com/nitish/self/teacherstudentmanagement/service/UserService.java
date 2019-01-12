package com.nitish.self.teacherstudentmanagement.service;

import com.nitish.self.teacherstudentmanagement.dto.UserDTO;
import com.nitish.self.teacherstudentmanagement.model.User;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;

public interface UserService {

    @PreAuthorize("hasAnyRole('ROLE_TEACHER')")
    List<User> getAllTeachers();

    List<User> getAllStudents();

    @PreAuthorize("#id == authentication.principal.id || hasAnyRole('ROLE_ADMIN')")
    User getUserById(Long id);

    @PreAuthorize("#userId == authentication.principal.id || hasAnyRole('ROLE_ADMIN')")
    UserDTO updateUser(Long userId, UserDTO userDTO);
}

