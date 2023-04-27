package com.training.controller;

import com.training.consts.ApiPath;
import com.training.dto.RoleDTO;
import com.training.repository.RoleRepository;
import com.training.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RoleController {
    @Autowired
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
    }
}
