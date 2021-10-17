package com.reto3.service;

import com.reto3.modelo.Message;
import com.reto3.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class MessageApi {
    /**
     * Inicializamos el repositorio Message
     */
    @Autowired
    private MessageRepository messageRepository;

    /**
     * Método para obtener todos los mensajes del repositorio
     * @return
     */
    public List<Message> getAll(){
        return messageRepository.getAll();
    }

    /**
     * Método para obtener un mensaje por id
     * @param id
     * @return
     */
    public Optional<Message> getMessage(int id){
        return messageRepository.getMessage(id);
    }

    /**
     * Método para agregar un mensaje
     * @param message
     * @return
     */
    public Message save(Message message){
        if(message.getIdMessage() == null){
            return messageRepository.save(message);
        }else{
            Optional<Message> evt = messageRepository.getMessage(message.getIdMessage());
            if(evt.isEmpty()){
                return messageRepository.save(message);
            }else{
                return message;
            }
        }
    }
}
