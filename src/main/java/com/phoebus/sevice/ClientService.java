package com.phoebus.sevice;

import com.phoebus.entites.Client;
import com.phoebus.exception.ClientException;
import com.phoebus.repository.ClientRepository;
import com.phoebus.sevice.serviceImpl.ClientServiceImpl;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import org.bson.types.ObjectId;

import java.util.List;
import java.util.Optional;

@Singleton
public class ClientService implements ClientServiceImpl {

    @Inject
    private ClientRepository clientRepository;

//    @Inject
//    private RedisToMongo redisToMongo;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
//        this.redisToMongo = redisToMongo;
    }

    public Iterable<Client> list(){
        return clientRepository.findAll();
    }


    public Client save(Client client) {
        return clientRepository.save(client);
    }


    public Optional<Client> findById(String id) throws ClientException {
        Optional<Client> clientOptional = clientRepository.findById(id);
        if(clientOptional.isEmpty()){
            throw new ClientException("Client Not Found");
        }
         return clientOptional;
    }


    public void deleteById(String id) throws ClientException {
        Optional<Client> clientOptional = clientRepository.findById(id);
        if(clientOptional.isEmpty()){
            throw new ClientException("Client Not Found");
        }
        clientRepository.deleteById(id);
    }
//
//
//    public void migrateFromRedisToMongo() {
//        redisToMongo.migrateFromRedisToMongo();
//    }
}
