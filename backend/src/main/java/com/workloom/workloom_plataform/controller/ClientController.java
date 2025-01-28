package com.workloom.workloom_plataform.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.workloom.workloom_plataform.services.ClientService;
import com.workloom.workloom_plataform.domain.users.client.*;
import com.workloom.workloom_plataform.domain.users.embedded.AddressDTO;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/client")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;
    private final ClientMapper mapper;

    @PostMapping("/clients")
    public ResponseEntity<Client> createClient(@RequestBody ClientRequestDTO body) {
        Client client = mapper.toEntity(body);
        Client createClient = clientService.createClient(client);
        return ResponseEntity.ok(client);
    }

    @PutMapping("/{id}/addresses")
    public ResponseEntity<Client> updateAddresses(@PathVariable UUID id, @RequestBody List<AddressDTO> addressDTOs) {
        Client updatedClient = clientService.editAddresses(id, addressDTOs);
        return ResponseEntity.ok(updatedClient);
    }

}
