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
@RequestMapping("/Message/")
public class MessageWeb {
    @Autowired
    private MessageApi messageApi;

    @GetMapping("all")
    public List<Message> getAll(){
        return messageApi.getAll();
    }

    @GetMapping("{id}")
    public Optional<Message> getMessage(@PathVariable("id") int id){
        return messageApi.getMessage(id);
    }

    @PostMapping("save")
    @ResponseStatus(HttpStatus.CREATED)
    public Message save(@RequestBody Message message){
        return messageApi.save(message);
    }
}
