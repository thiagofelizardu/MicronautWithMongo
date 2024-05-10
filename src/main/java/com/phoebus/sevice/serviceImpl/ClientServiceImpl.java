package com.phoebus.sevice.serviceImpl;

import com.phoebus.entites.Client;
import com.phoebus.exception.ClientException;
import org.bson.types.ObjectId;

import java.util.List;
import java.util.Optional;

public interface ClientServiceImpl {

    Iterable<Client> list();

    Client save(Client client);

    Optional<Client> findById(String id)throws ClientException;

    void deleteById(String id) throws ClientException;

    //void migrateFromRedisToMongo();
}

