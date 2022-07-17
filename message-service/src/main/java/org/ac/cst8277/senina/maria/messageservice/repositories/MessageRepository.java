package org.ac.cst8277.senina.maria.messageservice.repositories;

import org.ac.cst8277.senina.maria.messageservice.entities.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Integer> {
    List<Message> findAllMessagesByProducerId(int id);
}
