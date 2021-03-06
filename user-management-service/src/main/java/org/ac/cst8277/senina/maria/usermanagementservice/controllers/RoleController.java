package org.ac.cst8277.senina.maria.usermanagementservice.controllers;

import org.ac.cst8277.senina.maria.usermanagementservice.entities.Role;
import org.ac.cst8277.senina.maria.usermanagementservice.services.RoleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RoleController {
    private RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping("/roles")
    public List<Role> findAllRoles() {
        return roleService.findAllRoles();
    }
}
