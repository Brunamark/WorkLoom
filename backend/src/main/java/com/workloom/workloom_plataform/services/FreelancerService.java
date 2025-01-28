package com.workloom.workloom_plataform.services;

import java.util.ArrayList;
import java.util.UUID;
import org.springframework.stereotype.Service;

import com.workloom.workloom_plataform.domain.users.embedded.Address;
import com.workloom.workloom_plataform.domain.users.freelancer.Freelancer;
import com.workloom.workloom_plataform.domain.users.skill.Skill;
import com.workloom.workloom_plataform.repository.FreelancerRepository;
import com.workloom.workloom_plataform.repository.SkillRepository;

@Service
public class FreelancerService {

    private FreelancerRepository freelancerRepository;
    private SkillRepository skillRepository;

    public FreelancerService(FreelancerRepository freelancerRepository) {
        this.freelancerRepository = freelancerRepository;
    }
    
    private Freelancer findFreelanceById(UUID freelancerId) {
        return freelancerRepository.findById(freelancerId)
                .orElseThrow(() -> new RuntimeException("Freelancer not found!"));

    }

    public Freelancer addAddressToFreelancer(UUID freelancerId, Address newAddress) {
        Freelancer freelancer = findFreelanceById(freelancerId);
        freelancer.setAddress(newAddress);
        return freelancer;
    }

    public Freelancer editName(UUID freelancerId, String name) {
        Freelancer freelancer = findFreelanceById(freelancerId);
        freelancer.setName(name);
        return freelancer;
    }

    public Freelancer editEmail(UUID freelancerId, String email) {
        Freelancer freelancer = findFreelanceById(freelancerId);
        freelancer.setEmail(email);
        return freelancer;
    }

    public Freelancer editPassword(UUID freelancerId, String password) {
        Freelancer freelancer = findFreelanceById(freelancerId);
        freelancer.setPassword(password);
        return freelancer;
    }

    public Freelancer addInterestedField(UUID freelancerId, String field) {
        Freelancer freelancer = findFreelanceById(freelancerId);
        freelancer.getInterestFields().add(field);
        return freelancer;
    }

    public Freelancer removeInterestedField(UUID freelancerId, String field) {
        Freelancer freelancer = findFreelanceById(freelancerId);
        boolean removed = freelancer.getInterestFields()
                .removeIf(interestedField -> interestedField.equalsIgnoreCase(field));
        return removed ? freelancer : null;
    }

    public Freelancer editInterestedField(UUID freelancerId, String lastField, String newField) {
        Freelancer freelancer = findFreelanceById(freelancerId);

        if (freelancer.getInterestFields() == null) {
            throw new IllegalArgumentException("The intrested field does not exists");
        }

        boolean removed = freelancer.getInterestFields()
                .removeIf(interestedField -> interestedField.equalsIgnoreCase(lastField));

        if (!removed) {
            throw new IllegalArgumentException("Error in delete " + lastField);
        }
        freelancer.getInterestFields().add(newField);
        return freelancer;
    }

    public Freelancer addExperience(UUID freelancerId, String experience) {
        Freelancer freelancer = findFreelanceById(freelancerId);
        freelancer.getExperiences().add(experience);
        return freelancer;
    }

    public Freelancer removeExperience(UUID freelancerId, String experience) {
        Freelancer freelancer = findFreelanceById(freelancerId);
        if (freelancer.getExperiences() == null) {
            throw new IllegalArgumentException("Experience does not exists");
        }
        boolean removed = freelancer.getExperiences()
                .removeIf(freelancerExperience -> freelancerExperience.equalsIgnoreCase(experience));
        if (!removed) {
            throw new IllegalArgumentException("Error in delete " + experience);
        }
        return freelancer;

    }

    public Freelancer editExperice(UUID freelancerId, String lastExperience, String newExperience) {
        Freelancer freelancer = findFreelanceById(freelancerId);

        if (freelancer.getExperiences() == null) {
            throw new IllegalArgumentException("Experience does not exists");
        }

        boolean removed = freelancer.getExperiences()
                .removeIf(experience -> experience.equalsIgnoreCase(lastExperience));

        if (!removed) {
            throw new IllegalArgumentException("Error in delete " + lastExperience);
        }
        freelancer.getExperiences().add(newExperience);
        return freelancer;
    }

    public void addSkillToFreelancer(UUID freelancerId, UUID skillId) {
        Freelancer freelancer = freelancerRepository.findById(freelancerId).orElseThrow(() -> new RuntimeException("freelancer not found"));
        Skill skill = skillRepository.findById(skillId).orElseThrow(() -> new RuntimeException("Skill not found"));
        freelancer.addSkill(skill);
        freelancerRepository.save(freelancer);
    }

    public void removeSkillFromfreelancer(UUID freelancerId, UUID skillId) {
        Freelancer freelancer = freelancerRepository.findById(freelancerId).orElseThrow(() -> new RuntimeException("freelancer not found"));
        Skill skill = skillRepository.findById(skillId).orElseThrow(() -> new RuntimeException("Skill not found"));
        freelancer.removeSkill(skill);
        freelancerRepository.save(freelancer);
    }

    public void editfreelancerSkill(UUID freelancerId, UUID oldSkillId, UUID newSkillId) {
        Freelancer freelancer = freelancerRepository.findById(freelancerId).orElseThrow(() -> new RuntimeException("freelancer not found"));
        Skill oldSkill = skillRepository.findById(oldSkillId).orElseThrow(() -> new RuntimeException("Old skill not found"));
        Skill newSkill = skillRepository.findById(newSkillId).orElseThrow(() -> new RuntimeException("New skill not found"));
        freelancer.editSkill(oldSkill, newSkill);
        freelancerRepository.save(freelancer);
    }
    public Freelancer addEnterprise(UUID freelancerId, String enterprise) {
        Freelancer freelancer = findFreelanceById(freelancerId);

        if (freelancer.getEnterprises() == null) {
            freelancer.setEnterprises(new ArrayList<>());
        }

        freelancer.getEnterprises().add(enterprise);
        return freelancer;
    }

    public Freelancer removeEnterprise(UUID freelancerId, String enterprise) {
        Freelancer freelancer = findFreelanceById(freelancerId);

        if (freelancer.getEnterprises() == null) {
            throw new IllegalArgumentException("Enterprises do not exist");
        }

        boolean removed = freelancer.getEnterprises().removeIf(freelancerEnterprise -> freelancerEnterprise.equalsIgnoreCase(enterprise));
        if (!removed) {
            throw new IllegalArgumentException("Error in delete " + enterprise);
        }
        return freelancer;
    }

    public Freelancer editEnterprise(UUID freelancerId, String lastEnterprise, String newEnterprise) {
        Freelancer freelancer = findFreelanceById(freelancerId);

        if (freelancer.getEnterprises() == null) {
            throw new IllegalArgumentException("Enterprises do not exist");
        }

        boolean removed = freelancer.getEnterprises().removeIf(enterprise -> enterprise.equalsIgnoreCase(lastEnterprise));
        if (!removed) {
            throw new IllegalArgumentException("Error in delete " + lastEnterprise);
        }
        freelancer.getEnterprises().add(newEnterprise);
        return freelancer;
    }
}
