package com.nitish.self.teacherstudentmanagement.controller;

import com.nitish.self.teacherstudentmanagement.dto.ApiResponse;
import com.nitish.self.teacherstudentmanagement.dto.UserDTO;
import com.nitish.self.teacherstudentmanagement.service.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static com.nitish.self.teacherstudentmanagement.utils.ApiConstants.AUTH_PATH;
import static com.nitish.self.teacherstudentmanagement.utils.ApiConstants.REGISTER_PATH;

@RestController
@RequestMapping(AUTH_PATH)
public class AuthController {

    private final AuthService authService;

    public AuthController(final AuthService authService) {
        this.authService = authService;
    }

    @PostMapping(REGISTER_PATH)
    public ResponseEntity<ApiResponse> registerUser(@Valid @RequestBody UserDTO userDTO) {
        ApiResponse response = authService.register(userDTO);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
