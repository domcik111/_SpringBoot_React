package com.unicorn.hatchery.clientapp.service;

import com.unicorn.hatchery.clientapp.domain.Client;

import java.util.List;

public interface ClientService {

    Client createClient(Client client);

    Client readClient(Long clientId);

    void updateClient(Long clientId, Client client);

    void deleteClient(Long clientId);

    List<Client> getClients();
}
