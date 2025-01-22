package com.workloom.workloom_plataform.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.workloom.workloom_plataform.domain.users.client.ClientRequestDTO;
import com.workloom.workloom_plataform.services.ClientService;

import ch.qos.logback.core.net.server.Client;

@RestController
@RequestMapping("/client")
public class ClientController {

    private ClientService clientService;

    public ResponseEntity<Client> createClient(@RequestBody ClientRequestDTO body) {
        Client client = clientService.createClient(body);
        return ResponseEntity.ok(client);
    }
    
}
