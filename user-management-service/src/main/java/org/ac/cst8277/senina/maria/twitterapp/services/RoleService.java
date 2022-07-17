package org.ac.cst8277.senina.maria.twitterapp.services;

import org.ac.cst8277.senina.maria.twitterapp.entities.Role;
import org.ac.cst8277.senina.maria.twitterapp.repositories.RoleRepository;
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
