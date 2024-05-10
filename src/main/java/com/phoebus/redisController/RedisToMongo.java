//package com.phoebus.redisController;
//
//import com.phoebus.entites.Client;
//import com.phoebus.repository.ClientRepository;
//import io.lettuce.core.RedisClient;
//import io.lettuce.core.api.StatefulRedisConnection;
//import io.lettuce.core.api.sync.RedisCommands;
//import io.micronaut.context.annotation.Value;
//import jakarta.inject.Inject;
//import jakarta.inject.Singleton;
//import org.bson.types.ObjectId;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import java.util.Map;
//
//@Singleton
//public class RedisToMongo {
//
//
//    private static final Logger log = LoggerFactory.getLogger(RedisToMongo.class);
//    private StatefulRedisConnection<String, String> redisConnection;
//
//    private ClientRepository clientMongoRepository;
//
//    @Inject
//    public RedisToMongo(@Value("${redis.uri}") String redisUri, ClientRepository clientMongoRepository) {
//        this.redisConnection = RedisClient.create(redisUri).connect();
//        this.clientMongoRepository = clientMongoRepository;
//    }
//
//    public void migrateFromRedisToMongo() {
//        RedisCommands<String, String> commands = redisConnection.sync();
//
//        Map<String, String> clientesHash = commands.hgetall("clientes");
//
//        for (Map.Entry<String, String> entry : clientesHash.entrySet()) {
//            String key = entry.getKey();
//            String value = entry.getValue();
//
//            Client clientMongo = new Client(new ObjectId(key), value);
//
//            clientMongoRepository.save(clientMongo);
//
//            log.info("Chave: " + key + ", Valor: " + value + " salvo no MongoDB.");
//        }
//    }
//
//}
