package com.reto3.service;

import com.reto3.modelo.Client;
import com.reto3.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientApi {
    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAll(){
        return clientRepository.getAll();
    }

    public Optional<Client> getClient(int id){
        return clientRepository.getClient(id);
    }

    public Client save(Client client){
        if (client.getIdClient() == null){
            return clientRepository.save(client);
        }else{
            Optional<Client> evt = clientRepository.getClient(client.getIdClient());
            if(evt.isEmpty()){
                return clientRepository.save(client);
            }else{
                return client;
            }
        }
    }
}
