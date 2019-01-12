package com.nitish.self.teacherstudentmanagement.service.mapper;

import com.nitish.self.teacherstudentmanagement.dto.UserDTO;
import com.nitish.self.teacherstudentmanagement.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserMapperService {

    public User UserDTOToUser(UserDTO userDTO){
        if(userDTO == null){ return null;}
        User user = new User();
        user.setName(userDTO.getName());
        user.setUsername(userDTO.getUsername());
        user.setEmail(userDTO.getEmail());
        return user;
    }

    public UserDTO UserToUserDTO(User user){
        if(user == null){ return null;}
        UserDTO userDTO = new UserDTO();
        userDTO.setName(user.getName());
        userDTO.setUsername(user.getUsername());
        userDTO.setEmail(user.getEmail());
        return userDTO;
    }
}
