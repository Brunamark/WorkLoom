package com.workloom.workloom_plataform.repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.workloom.workloom_plataform.domain.users.Freelancer;

@Repository
public interface FreelancerRepository extends JpaRepository<Freelancer,UUID> {
    
}
