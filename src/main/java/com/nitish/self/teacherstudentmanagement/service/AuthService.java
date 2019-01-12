package com.nitish.self.teacherstudentmanagement.service;

import com.nitish.self.teacherstudentmanagement.dto.ApiResponse;
import com.nitish.self.teacherstudentmanagement.dto.UserDTO;

public interface AuthService {

    ApiResponse register(UserDTO userDTO);
}