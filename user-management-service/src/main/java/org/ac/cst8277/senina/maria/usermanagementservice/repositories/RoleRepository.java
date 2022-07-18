package org.ac.cst8277.senina.maria.usermanagementservice.repositories;

import org.ac.cst8277.senina.maria.usermanagementservice.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
}
