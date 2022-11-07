package com.unicorn.hatchery.clientapp.controller;

import com.unicorn.hatchery.clientapp.domain.Client;
import com.unicorn.hatchery.clientapp.service.ClientService;
import com.unicorn.hatchery.clientapp.service.ClientServiceimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {
    private ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping
    public Client createClient(@RequestBody Client client) {
        return clientService.createClient(client) ;
    }

    @GetMapping("/{id}")
    public Client readClient(@PathVariable("id") Long clientId) {
        return clientService.readClient(clientId);
    }
    @PutMapping("/{id}")
    public void updateClient(@PathVariable("id") Long clientId,
                             @RequestBody Client client) {
        clientService.updateClient(clientId, client);
    }

    @DeleteMapping("/{id}")
    public void deleteClient(@PathVariable("id") Long clientId) {

        clientService.deleteClient(clientId);
    }
    @GetMapping
    public List<Client> getClients() {
        return clientService.getClients();
    }


}
