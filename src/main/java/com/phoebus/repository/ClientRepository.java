package com.phoebus.repository;

import com.phoebus.entites.Client;
import io.micronaut.data.mongodb.annotation.MongoRepository;
import io.micronaut.data.repository.CrudRepository;

@MongoRepository
public interface ClientRepository extends CrudRepository<Client, String> {
}
