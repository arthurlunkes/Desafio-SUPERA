package dev.arthurlunkes.CRUDClients.repositories;

import dev.arthurlunkes.CRUDClients.models.ClientModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<ClientModel, Long> {
}