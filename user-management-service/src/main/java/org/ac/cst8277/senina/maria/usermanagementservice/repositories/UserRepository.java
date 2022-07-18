package org.ac.cst8277.senina.maria.usermanagementservice.repositories;

import org.ac.cst8277.senina.maria.usermanagementservice.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByEmailAndPassword(String email, String password);
}
