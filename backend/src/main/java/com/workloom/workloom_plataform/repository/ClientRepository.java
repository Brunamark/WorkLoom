package com.workloom.workloom_plataform.repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.workloom.workloom_plataform.domain.users.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client,UUID> {
    
}
