package com.nitish.self.teacherstudentmanagement.controller;

import com.nitish.self.teacherstudentmanagement.dto.UserDTO;
import com.nitish.self.teacherstudentmanagement.model.User;
import com.nitish.self.teacherstudentmanagement.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.nitish.self.teacherstudentmanagement.utils.ApiConstants.*;

@RestController
@RequestMapping(REST_PATH + USERS_PATH)
public class UserController {

    private final UserService userService;

    public UserController(final UserService userService) {
        this.userService = userService;
    }

    @GetMapping(TEACHERS_PATH)
    public ResponseEntity<List<User>> getAllTeachers() {
        List<User> teachers = userService.getAllTeachers();
        return new ResponseEntity<>(teachers, HttpStatus.OK);
    }

    @GetMapping(STUDENTS_PATH)
    public ResponseEntity<List<User>> getAllStudents() {
        List<User> students = userService.getAllStudents();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @GetMapping(ID_PATH)
    public ResponseEntity<User> getById(@PathVariable Long id) {
        User user = userService.getUserById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PutMapping(ID_PATH)
    public ResponseEntity<UserDTO> updateUser(@PathVariable Long id, @RequestBody UserDTO userDTO) {
        UserDTO user = userService.updateUser(id, userDTO);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
