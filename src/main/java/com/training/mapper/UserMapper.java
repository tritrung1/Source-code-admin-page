package com.training.mapper;

import com.training.dto.UserDTO;
import com.training.entity.User;
import org.springframework.stereotype.Service;

@Service
public class UserMapper extends AbstractMapper<User, UserDTO> {
    public UserMapper() {
        super(User.class, UserDTO.class);
    }
}
