package com.unicorn.hatchery.clientapp.service;

import com.unicorn.hatchery.clientapp.domain.Client;
import com.unicorn.hatchery.clientapp.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ClientServiceimpl implements ClientService {

    private ClientRepository clientRepository;
    @Autowired
    public ClientServiceimpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public Client createClient(Client client) {
        return clientRepository.save(client) ;
    }

    @Override
    public Client readClient(Long clientId) {
        return clientRepository.findById(clientId).orElseThrow(() -> new IllegalArgumentException());
    }

    @Override
    public void updateClient(Long clientId, Client client) {
        Client clientToUpdate = clientRepository.findById(clientId).orElseThrow(() -> new IllegalArgumentException());
                clientToUpdate.setName(client.getName());
                clientToUpdate.setEmail(client.getEmail());
                clientRepository.save(clientToUpdate);
    }

    @Override
    public void deleteClient(Long clientId) {
            clientRepository.deleteById(clientId);
    }

    @Override
    public List<Client> getClients() {
        return StreamSupport
                .stream(clientRepository.findAll().spliterator(),false)
                .collect(Collectors.toList());

    }
}
