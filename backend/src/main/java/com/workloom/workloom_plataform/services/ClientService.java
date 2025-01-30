package com.workloom.workloom_plataform.services;

import com.workloom.workloom_plataform.domain.users.client.Client;
import com.workloom.workloom_plataform.domain.users.embedded.Address;
import com.workloom.workloom_plataform.domain.users.embedded.AddressDTO;
import com.workloom.workloom_plataform.domain.users.skill.Skill;
import com.workloom.workloom_plataform.repository.ClientRepository;
import com.workloom.workloom_plataform.repository.SkillRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ClientService {

    private ClientRepository clientRepository;
    private SkillRepository skillRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client createClient(Client client) {
        Client newClient = new Client();
        newClient.setName(client.getName());
        newClient.setEmail(client.getEmail());
        newClient.setCnpj(client.getCnpj());
        newClient.setRole(client.getRole());
        newClient.setEnterpriseName(client.getEnterpriseName());
        newClient.setSkills(client.getSkills());
        

        List<Address> addresses = newClient.getAddress().stream().map(dto -> {
            Address address = new Address();
            address.setStreetName(dto.getStreetName());
            address.setStreetNumber(dto.getStreetNumber());
            address.setCity(dto.getCity());
            address.setState(dto.getState());
            address.setZipCode(dto.getZipCode());
            return address;
        }).collect(Collectors.toList());
    
        newClient.setAddress(addresses);

        return clientRepository.save(newClient);
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
        Skill oldSkill = skillRepository.findById(oldSkillId)
                .orElseThrow(() -> new RuntimeException("Old skill not found"));
        Skill newSkill = skillRepository.findById(newSkillId)
                .orElseThrow(() -> new RuntimeException("New skill not found"));
        client.editSkill(oldSkill, newSkill);
        clientRepository.save(client);
    }

    public Client editAddresses(UUID clientId, List<AddressDTO> addressDTOs) {
        Client client = findClientById(clientId);
        List<Address> addresses = addressDTOs.stream().map(dto -> {
            Address address = new Address();
            address.setStreetName(dto.getStreetName());
            address.setStreetNumber(dto.getStreetNumber());
            address.setCity(dto.getCity());
            address.setState(dto.getState());
            address.setZipCode(dto.getZipCode());
            return address;
        }).collect(Collectors.toList());

        client.setAddress(addresses);
        return clientRepository.save(client);
    }
}
