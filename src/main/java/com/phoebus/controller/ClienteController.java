package com.phoebus.controller;


import com.phoebus.entites.Client;
import com.phoebus.exception.ClientException;
import com.phoebus.sevice.ClientService;
import com.phoebus.sevice.serviceImpl.ClientServiceImpl;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Delete;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.Status;
import io.micronaut.scheduling.TaskExecutors;
import io.micronaut.scheduling.annotation.ExecuteOn;
import org.bson.types.ObjectId;

import java.util.List;
import java.util.Optional;

@Controller("/client")
@ExecuteOn(TaskExecutors.IO)
public class ClienteController {

    private final ClientServiceImpl clientService;

    public ClienteController(ClientService clientService) {
        this.clientService = clientService;
    }

    @Get("/")
    @Status(HttpStatus.OK)
    public Iterable<Client> ClientList() {
        return clientService.list();
    }

    @Post
    @Status(HttpStatus.CREATED)
    public Client ClientSave(@Body Client client) {
        return clientService.save(client);
    }

    @Get("/{id}")
    @Status(HttpStatus.OK)
    public Optional<Client> ClientFindById(@PathVariable String id) throws ClientException {
        return clientService.findById(id);
    }
    @Delete("delete/{id}")
    @Status(HttpStatus.ACCEPTED)
    public void ClientDeleteById(@PathVariable String id) throws ClientException {
        clientService.deleteById(id);
    }

//    @Post("/migrar")
//    public void migrarDadosDoRedisParaMongo(){
//        clientService.migrateFromRedisToMongo();
//    }

}
