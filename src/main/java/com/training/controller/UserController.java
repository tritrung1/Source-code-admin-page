package com.training.controller;

import com.training.consts.ApiPath;
import com.training.dto.UserDTO;
import com.training.repository.UserRepository;
import com.training.servcie.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    UserService service;

    @GetMapping(value = ApiPath.PING)
    public String ping() {
        return "Ping!!!!!!!!";
    }

    @PostMapping(value = ApiPath.USER_CREATE)
    public UserDTO newUser(@RequestBody UserDTO newUser) {
        return service.save(newUser);
    }

    @GetMapping(value = ApiPath.USER_GET_ALL)
    public List<UserDTO> getAllUsers() {
        return service.findAll();
    }

    @GetMapping(value = ApiPath.USER_BY_ID)
    public UserDTO getUserById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PutMapping(value = ApiPath.USER_UPDATE)
     public Integer updateUser(@RequestBody UserDTO newUser) {
        return service.update(newUser);
    }

    @DeleteMapping(value = ApiPath.USER_DELETE)
    public String deleteUser(@RequestBody UserDTO newUser) {
        boolean isDelete = service.delete(newUser);
        return  isDelete ? "Delete success!!!" : "Delete fail!!!";
    }


}
