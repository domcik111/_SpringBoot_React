package com.unicorn.hatchery.clientapp.repository;

import com.unicorn.hatchery.clientapp.domain.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends CrudRepository<Client, Long> {



}
