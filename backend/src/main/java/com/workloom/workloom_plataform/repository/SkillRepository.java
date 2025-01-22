package com.workloom.workloom_plataform.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.workloom.workloom_plataform.domain.users.*;
import com.workloom.workloom_plataform.domain.users.skill.Skill;

import java.util.UUID;

@Repository
public interface SkillRepository extends JpaRepository <Skill, UUID> {
    
}
