package com.reto3.repository;

import com.reto3.modelo.Message;
import com.reto3.repository.crud.MessageCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public class MessageRepository {
    /**
     * Atributo Repositorio Message
     */
    @Autowired
    private MessageCrudRepository messageCrudRepository;

    /**
     * Método para obtener todos los mensajes del repositorio
     * @return
     */
    public List<Message> getAll(){
        return (List<Message>) messageCrudRepository.findAll();
    }

    /**
     * Método para obtener un mensaje por id
     * @param id
     * @return
     */
    public Optional<Message> getMessage(int id){
        return messageCrudRepository.findById(id);
    }

    /**
     * Método para agregar un mensaje
     * @param message
     * @return
     */
    public Message save(Message message){
        return messageCrudRepository.save(message);
    }

    /**
     * Método para eliminar un mensaje
     * @param message
     */
    public void delete(Message message){
        messageCrudRepository.delete(message);
    }
}
