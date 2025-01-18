package com.workloom.workloom_plataform.services;

import java.util.UUID;
import org.springframework.stereotype.Service;
import com.workloom.workloom_plataform.domain.users.Address;
import com.workloom.workloom_plataform.domain.users.Freelancer;
import com.workloom.workloom_plataform.repository.FreelancerRepository;

@Service
public class FreelancerService {
    
    private FreelancerRepository freelancerRepository;

    private Freelancer findFreelanceById(UUID freelancerId){
        return freelancerRepository.findById(freelancerId)
        .orElseThrow(()-> new RuntimeException("Freelancer not found!"));

    }

    public Freelancer addAddressToFreelancer(UUID freelancerId, Address newAddress){
        Freelancer freelancer = findFreelanceById(freelancerId);
        freelancer.setAddress(newAddress);
        return freelancer;
    }

    public Freelancer editName(UUID freelancerId, String name){
        Freelancer freelancer = findFreelanceById(freelancerId);
        freelancer.setName(name);
        return freelancer;
    }

    public Freelancer editEmail(UUID freelancerId, String email){
        Freelancer freelancer = findFreelanceById(freelancerId);
        freelancer.setEmail(email);
        return freelancer;
    }

    public Freelancer editPassword(UUID freelancerId, String password){
        Freelancer freelancer = findFreelanceById(freelancerId);
        freelancer.setPassword(password);
        return freelancer;
    }

    public Freelancer addInterestedField(UUID freelancerId, String field){
        Freelancer freelancer = findFreelanceById(freelancerId);
        freelancer.getInterestFields().add(field);
        return freelancer;
    }

    public Freelancer removeInterestedField(UUID freelancerId, String field){
        Freelancer freelancer = findFreelanceById(freelancerId);
        boolean removed = freelancer.getInterestFields()
            .removeIf(interestedField -> interestedField.equalsIgnoreCase(field));
        return removed?freelancer:null;
    }

    public Freelancer editInterestedField(UUID freelancerId, String lastField, String newField){
        Freelancer freelancer = findFreelanceById(freelancerId);

        if(freelancer.getInterestFields() == null){
            throw new IllegalArgumentException("The field '" + lastField + "' does not exists");
        }

        boolean removed = freelancer.getInterestFields()
                         .removeIf(interestedField -> interestedField.equalsIgnoreCase(lastField));
      
        if(!removed){
            throw new IllegalArgumentException("Error in delete "+ lastField);
        }
        freelancer.getInterestFields().add(newField);
        return freelancer;
    }

    public Freelancer addExperience(UUID freelancerId, String experience){
        Freelancer freelancer = findFreelanceById(freelancerId);
        freelancer.getExperiences().add(experience);
        return freelancer;
    }

    public Freelancer removeExperience(UUID freelancerId, String experience){
        Freelancer freelancer = findFreelanceById(freelancerId);
        if(freelancer.getExperiences() == null){
            throw new IllegalArgumentException("Experience does not exists");
        }
        boolean removed = freelancer.getExperiences()
                            .removeIf(freelancerExperience -> freelancerExperience.equalsIgnoreCase(experience));
        if(!removed){
            throw new IllegalArgumentException("Error in delete "+ experience);
        }
        return freelancer;

    }

}
