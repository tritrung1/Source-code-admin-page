package com.training.service.impl;

import com.fasterxml.uuid.Generators;
import com.training.dto.RoleDTO;
import com.training.entity.Role;
import com.training.mapper.RoleMapper;
import com.training.repository.RoleRepository;
import com.training.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleRepository roleRepository;

    @Autowired
    RoleMapper roleMapper;

    @Override
    public List<RoleDTO> findAll() {
        List<Role> roles = roleRepository.findAll();
        return roles == null || roles.size() == 0 ? new ArrayList<>()
                : roles.stream().map(item -> roleMapper.convertEntityToDTO(item))
                .collect(Collectors.toList());
    }

    @Override
    public RoleDTO findById(Long id) {
        Optional<Role> role = roleRepository.findById(id);
        return role != null && role.isPresent() ? roleMapper.convertEntityToDTO(role.get())
                : new RoleDTO();
    }

    @Override
    public RoleDTO save(RoleDTO roleDTO) {
        if (roleDTO == null) return new RoleDTO();
        // get unique uuid
        UUID uuid = Generators.timeBasedGenerator().generate();

        // set field or data for generate UUID
        roleDTO.setRoleUuid(uuid.toString());

        Role role = roleRepository.save(roleMapper.convertDTOToEntity(roleDTO));
        return role == null ? new RoleDTO() : roleMapper.convertEntityToDTO(role);
    }

    @Override
    public int update(RoleDTO roleDTO) {
        if (roleDTO == null || roleDTO.getId() == null) return -1;
        Optional<Role> role = roleRepository.findById(roleDTO.getId());
        if (role != null && role.isPresent()) {
            //update
            Role roleUpdate = roleRepository.save(roleMapper.convertDTOToEntity(roleDTO));
            return roleUpdate == null ? 0 : 1;
        }
        return -1;
    }

    @Override
    public boolean delete(RoleDTO roleDTO) {
        try {
            if (roleDTO == null || roleDTO.getId() == null) return false;
            Optional<Role> role = roleRepository.findById(roleDTO.getId());
            if (role != null && role.isPresent()) {
                //delete
                roleRepository.delete(role.get());
                return true;
            }
            return false;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

}
