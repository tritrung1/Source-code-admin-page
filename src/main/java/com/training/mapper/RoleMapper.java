package com.training.mapper;

import com.training.dto.RoleDTO;
import com.training.entity.Role;
import org.springframework.stereotype.Service;

@Service
public class RoleMapper extends AbstractMapper<Role, RoleDTO> {
    public RoleMapper() {
        super(Role.class, RoleDTO.class);
    }
}
