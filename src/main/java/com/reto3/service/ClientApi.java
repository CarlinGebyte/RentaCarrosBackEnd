package com.reto3.service;
import com.reto3.modelo.Client;
import com.reto3.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ClientApi {
    /**
     * Inicializamos el repositorio
     */
    @Autowired
    private ClientRepository clientRepository;

    /**
     * Método para obtener todos los clientes del repositorio
     * @return
     */
    public List<Client> getAll(){
        return clientRepository.getAll();
    }

    /**
     * Método para obtener un cliente por id
     * @param id
     * @return
     */
    public Optional<Client> getClient(int id){
        return clientRepository.getClient(id);
    }

    /**
     * Método para agregar un cliente
     * @param client
     * @return
     */
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

    /**
     * Método para actualizar un cliente
     * @param client
     * @return
     */
    public Client update(Client client){
        if (client.getIdClient() != null){
            Optional<Client> evnt = clientRepository.getClient(client.getIdClient());
            if (!evnt.isEmpty()){
                if (client.getName() != null){
                    evnt.get().setName(client.getName());
                }
                if (client.getAge() != 0){
                    evnt.get().setAge(client.getAge());
                }
                if (client.getPassword() != null){
                    evnt.get().setPassword(client.getPassword());
                }
                clientRepository.save(evnt.get());
                return evnt.get();
            }else{
                return client;
            }
        }else{
            return client;
        }
    }

    /**
     * Método para eliminar un cliente
     * @param id
     * @return
     */
    public boolean delete(int id){
        Boolean flag = getClient(id).map(client -> {
            clientRepository.delete(client);
            return true;
        }).orElse(false);
        return flag;
    }
}
