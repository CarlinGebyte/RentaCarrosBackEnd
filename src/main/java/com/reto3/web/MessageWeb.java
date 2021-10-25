package com.reto3.web;

import com.reto3.modelo.Message;
import com.reto3.service.MessageApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RequestMapping("/api/Message/")
public class MessageWeb {
    /**
     * Inicializamos Api Message
     */
    @Autowired
    private MessageApi messageApi;

    /**
     * Método para obtener todos los mensajes desde URL
     * @return
     */
    @GetMapping("all")
    public List<Message> getAll(){
        return messageApi.getAll();
    }

    /**
     * Método para obtener un mensajes por id desde URL
     * @param id
     * @return
     */
    @GetMapping("{id}")
    public Optional<Message> getMessage(@PathVariable("id") int id){
        return messageApi.getMessage(id);
    }

    /**
     * Método para agregar un mensaje desde URL
     * @param message
     * @return
     */
    @PostMapping("save")
    @ResponseStatus(HttpStatus.CREATED)
    public Message save(@RequestBody Message message){
        return messageApi.save(message);
    }

    @PutMapping("update")
    @ResponseStatus(HttpStatus.CREATED)
    public Message update(@RequestBody Message message){
        return messageApi.update(message);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id){
        return messageApi.delete(id);
    }
}
