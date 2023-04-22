package com.training.servcie.impl;

import com.training.dto.UserDTO;
import com.training.entity.User;
import com.training.mapper.UserMapper;
import com.training.repository.UserRepository;
import com.training.servcie.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository repository;

    @Autowired
    UserMapper mapper;

    @Override
    public List<UserDTO> findAll() {
        List<User> users = repository.findAll();
        return users == null || users.size() == 0 ? new ArrayList<>()
                : users.stream().map(item -> mapper.convertEntityToDTO(item))
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO findById(Long id) {
        Optional<User> user = repository.findById(id);
        return user != null && user.isPresent() ? mapper.convertEntityToDTO(user.get())
                : new UserDTO();
    }

    @Override
    public UserDTO save(UserDTO userDTO) {
        if (userDTO == null) return new UserDTO();
        User user = repository.save(mapper.convertDTOToEntity(userDTO));
        return user == null ? new UserDTO() : mapper.convertEntityToDTO(user);
    }

    @Override
    public int update(UserDTO userDTO) {
        if (userDTO == null || userDTO.getId() == null) return -1;
        Optional<User> user = repository.findById(userDTO.getId());
        if (user != null && user.isPresent()) {
            //update
            User userUpdate = repository.save(mapper.convertDTOToEntity(userDTO));
            return userUpdate == null ? 0 : 1;
        }
        return -1;
    }

    @Override
    public boolean delete(UserDTO userDTO) {
        try {
            if (userDTO == null || userDTO.getId() == null) return false;
            Optional<User> user = repository.findById(userDTO.getId());
            if (user != null && user.isPresent()) {
                //delete
                repository.delete(user.get());
                return true;
            }
            return false;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
