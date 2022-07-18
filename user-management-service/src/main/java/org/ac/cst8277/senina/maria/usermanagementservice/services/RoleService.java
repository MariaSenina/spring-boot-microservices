package org.ac.cst8277.senina.maria.usermanagementservice.services;

import org.ac.cst8277.senina.maria.usermanagementservice.entities.Role;
import org.ac.cst8277.senina.maria.usermanagementservice.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {
    private RoleRepository roleRepository;

    @Autowired
    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public List<Role> findAllRoles() {
        return roleRepository.findAll();
    }
}
