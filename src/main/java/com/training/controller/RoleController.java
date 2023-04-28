package com.training.controller;

import com.training.consts.ApiPath;
import com.training.dto.RoleDTO;
import com.training.repository.RoleRepository;
<<<<<<< Updated upstream
import com.training.service.RoleService;
=======
import com.training.servcie.RoleService;
>>>>>>> Stashed changes
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RoleController {
    @Autowired
<<<<<<< Updated upstream
    private RoleRepository roleRepository;

    @Autowired
    RoleService service;

    @PostMapping(value = ApiPath.NOTIFICATION_CREATE)
    public RoleDTO newRole(@RequestBody RoleDTO newRole) {
        return service.save(newRole);
    }

    @GetMapping(value = ApiPath.NOTIFICATION_GET_ALL)
    public List<RoleDTO> getAllRoles() {
        return service.findAll();
    }

    @GetMapping(value = ApiPath.NOTIFICATION_BY_ID)
    public RoleDTO getRoleById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PutMapping(value = ApiPath.NOTIFICATION_UPDATE)
    public Integer updateRole(@RequestBody RoleDTO newRole) {
        return service.update(newRole);
    }

    @DeleteMapping(value = ApiPath.NOTIFICATION_DELETE)
    public String deleteRole(@RequestBody RoleDTO newRole) {
        boolean isDelete = service.delete(newRole);
        return  isDelete ? "Delete success!!!" : "Delete fail!!!";
=======
    RoleRepository roleRepository;
    @Autowired
    RoleService roleService;

    @PostMapping(value = ApiPath.ROLE_CREATE)
    public RoleDTO newRole(@RequestBody RoleDTO newRole) {
        return roleService.save(newRole);
    }

    @GetMapping(value = ApiPath.ROLE_GET_ALL)
    public List<RoleDTO> getAllRole() {
        return roleService.findAll();
    }

    @GetMapping(value = ApiPath.ROLE_BY_ID)
    public RoleDTO getRoleById(@PathVariable Long id) {
        return roleService.findById(id);
    }

    @PutMapping(value = ApiPath.ROLE_UPDATE)
    public Integer updateRole(@RequestBody RoleDTO newRole) {
        return roleService.update(newRole);
    }

    @DeleteMapping(value = ApiPath.ROLE_DELETE)
    public String deleteRole(@RequestBody RoleDTO newRole) {
        boolean isDelete = roleService.delete(newRole);
        return isDelete ? "Delete success!!!" : "Delete fail";
>>>>>>> Stashed changes
    }
}
