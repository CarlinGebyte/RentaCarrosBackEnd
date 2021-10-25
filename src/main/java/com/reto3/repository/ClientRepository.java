package com.reto3.repository;

import com.reto3.modelo.Client;
import com.reto3.repository.crud.ClientCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public class ClientRepository {
    /**
     * Atributo Repositorio CLient
     */
    @Autowired
    private ClientCrudRepository clientCrudRepository;

    /**
     * Método para encontrar todos los clientes del repositorio
     * @return
     */
    public List<Client> getAll(){
        return (List<Client>) clientCrudRepository.findAll();
    }

    /**
     * Método para encontrar un cliente por id
     * @param id
     * @return
     */
    public Optional<Client> getClient(int id){
        return clientCrudRepository.findById(id);
    }

    /**
     * Método para agregar un cliente
     * @param client
     * @return
     */
    public Client save(Client client){
        return clientCrudRepository.save(client);
    }

    /**
     * Método para eliminar un cliente
     * @param client
     */
    public void delete(Client client){
        clientCrudRepository.delete(client);
    }
}
