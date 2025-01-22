package com.workloom.workloom_plataform.services;

import com.workloom.workloom_plataform.domain.users.client.Client;
import com.workloom.workloom_plataform.domain.users.client.ClientRequestDTO;
import com.workloom.workloom_plataform.domain.users.skill.Skill;
import com.workloom.workloom_plataform.repository.ClientRepository;
import com.workloom.workloom_plataform.repository.SkillRepository;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ClientService {

    private ClientRepository clientRepository;
    private SkillRepository skillRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client createClient(ClientRequestDTO data) {
        Client client = new Client();
        client.setName(data.getName());
        client.setEmail(data.getEmail());
        client.setPassword(data.getPassword());
        client.setCnpj(data.getCnpj());
        client.setRole(data.getRole());
        client.setEnterpriseName(data.getEnterpriseName());
        client.setSkills(data.getSkills());
        ///client.setStreetName(data.getStreetName());


        return clientRepository.save(client);
    }
    private Client findClientById(UUID clientId) {
        return clientRepository.findById(clientId)
                .orElseThrow(() -> new RuntimeException("Client not found!"));
    }

    public Client editName(UUID clientId, String name) {
        Client client = findClientById(clientId);
        client.setName(name);
        return client;
    }

    public Client editEmail(UUID clientId, String email) {
        Client client = findClientById(clientId);
        client.setEmail(email);
        return client;
    }

    public Client editPassword(UUID clientId, String password) {
        Client client = findClientById(clientId);
        client.setPassword(password);
        return client;
    }

    public Client addEnterpriseName(UUID clientId, String enterpriseName) {
        Client client = findClientById(clientId);
        client.setName(enterpriseName);
        return client;
    }

    public Client editEnterpriseName(UUID clientId, String newEnterpriseName) {
        Client client = findClientById(clientId);
        if (client.getName() == null) {
            throw new IllegalArgumentException("Enterprise name do not exist");
        }
        
        client.setEnterpriseName(newEnterpriseName);
        return client;
    }

    public Client addCnpj(UUID clientId, String cnpj) {
        Client client = findClientById(clientId);
        if (client.getCnpj() == null) {
            throw new IllegalArgumentException("Enterprise cnpj do not exist");
        }
        client.setCnpj(cnpj);
        return client;
    }


    public Client editCnpj(UUID clientId, String newCnpj) {
        Client client = findClientById(clientId);
        if (client.getCnpj() == null) {
            throw new IllegalArgumentException("Enterprise cnpj do not exist");
        }
        client.setCnpj(newCnpj);
        return client;
    }

    public void addSkillToClient(UUID clientId, UUID skillId) {
        Client client = clientRepository.findById(clientId).orElseThrow(() -> new RuntimeException("Client not found"));
        Skill skill = skillRepository.findById(skillId).orElseThrow(() -> new RuntimeException("Skill not found"));
        client.addSkill(skill);
        clientRepository.save(client);
    }

    public void removeSkillFromClient(UUID clientId, UUID skillId) {
        Client client = clientRepository.findById(clientId).orElseThrow(() -> new RuntimeException("Client not found"));
        Skill skill = skillRepository.findById(skillId).orElseThrow(() -> new RuntimeException("Skill not found"));
        client.removeSkill(skill);
        clientRepository.save(client);
    }

    public void editClientSkill(UUID clientId, UUID oldSkillId, UUID newSkillId) {
        Client client = clientRepository.findById(clientId).orElseThrow(() -> new RuntimeException("Client not found"));
        Skill oldSkill = skillRepository.findById(oldSkillId).orElseThrow(() -> new RuntimeException("Old skill not found"));
        Skill newSkill = skillRepository.findById(newSkillId).orElseThrow(() -> new RuntimeException("New skill not found"));
        client.editSkill(oldSkill, newSkill);
        clientRepository.save(client);
    }
}
