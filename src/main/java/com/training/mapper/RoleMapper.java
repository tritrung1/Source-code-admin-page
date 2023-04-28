package com.training.mapper;

import com.training.dto.RoleDTO;
import com.training.entity.Role;
import org.springframework.stereotype.Service;

@Service
<<<<<<< Updated upstream
public class RoleMapper extends AbstractMapper<Role, RoleDTO> {
    public RoleMapper() {
=======
public class RoleMapper extends AbstractMapper<Role, RoleDTO>{
    public RoleMapper(){
>>>>>>> Stashed changes
        super(Role.class, RoleDTO.class);
    }
}
