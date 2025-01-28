package com.workloom.workloom_plataform.services;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.workloom.workloom_plataform.domain.users.skill.Skill;
import com.workloom.workloom_plataform.repository.SkillRepository;

@Service
public class SkillService {
    public SkillRepository skillRepository;

    public SkillService(SkillRepository skillRepository) {
        this.skillRepository = skillRepository;
    }

    public Skill addSkill(String name) {
        Skill skill = new Skill();
        skill.setName(name);
        return skillRepository.save(skill);
    }

    public Skill editSkill(UUID id, String newName) {
        Skill skill = skillRepository.findById(id).orElseThrow(() -> new RuntimeException("Skill not found"));
        skill.setName(newName);
        return skillRepository.save(skill);
    }

    public void removeSkill(UUID id) {
        Skill skill = skillRepository.findById(id).orElseThrow(() -> new RuntimeException("Skill not found"));
        skillRepository.delete(skill);
    }

}
