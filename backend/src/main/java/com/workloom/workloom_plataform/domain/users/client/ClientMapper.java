package com.workloom.workloom_plataform.domain.users.client;


import java.util.ArrayList;
import java.util.List;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.workloom.workloom_plataform.domain.users.embedded.Address;
import com.workloom.workloom_plataform.domain.users.embedded.AddressDTO;

@Component
public class ClientMapper {
        private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        

        // GET requests
        public ClientRequestDTO toDTO(Client client) {
                ClientRequestDTO dto = new ClientRequestDTO();
                dto.setId(client.getId());
                dto.setName(client.getName());
                dto.setEmail(client.getEmail());
                dto.setRole(client.getRole());
                dto.setSkills(client.getSkills());
                dto.setEnterpriseName(client.getEnterpriseName());
                dto.setCnpj(client.getCnpj());
                dto.setPhone(client.getPhone());

                List<AddressDTO> addressDTOs = client.getAddress().stream()
                                .map(address -> new AddressDTO(
                                                address.getStreetName(),
                                                address.getStreetNumber(),
                                                address.getCity(),
                                                address.getState(),
                                                address.getZipCode()))
                                .toList();
                dto.setAddresses(addressDTOs);

                return dto;
        }

        // POST requests
        public Client toEntity(ClientRequestDTO dto) {
                Client client = new Client();
                client.setName(dto.getName());
                client.setEmail(dto.getEmail());
                client.setRole(dto.getRole());
                client.setSkills(dto.getSkills());
                client.setEnterpriseName(dto.getEnterpriseName());
                client.setCnpj(dto.getCnpj());
                client.setPhone(dto.getPhone());

                String encryptedPassword = passwordEncoder.encode(dto.getPassword());
                client.setPassword(encryptedPassword);
                if(dto.getAddresses() != null){
                        List<Address> addresses = dto.getAddresses().stream()
                        .map(addressDTO -> new Address(
                                        addressDTO.getStreetName(),
                                        addressDTO.getStreetNumber(),
                                        addressDTO.getCity(),
                                        addressDTO.getState(),
                                        addressDTO.getZipCode()))
                        .toList();
                        client.setAddress(addresses);  
                }else{
                        client.setAddress(new ArrayList<>());
                }
                return client;
        }
}
