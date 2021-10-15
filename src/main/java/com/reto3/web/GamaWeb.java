package com.reto3.web;

import com.reto3.modelo.Gama;
import com.reto3.service.GamaApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RequestMapping("/api/Gama/")
public class GamaWeb {
    /**
     * Inicializamos Api Gama
     */
    @Autowired
    private GamaApi gamaApi;

    /**
     * Método para obtener todas las gamas por URL
     * @return
     */
    @GetMapping("all")
    public List<Gama> getAll(){
        return gamaApi.getAll();
    }

    /**
     * Método para obtener una gama por id desde URL
     * @param id
     * @return
     */
    @GetMapping("{id]")
    public Optional<Gama> getGama(@PathVariable("id") int id){
        return gamaApi.getGama(id);
    }

    /**
     * Método para agregar una gama por URL
     * @param gama
     * @return
     */
    @PostMapping("save")
    @ResponseStatus(HttpStatus.CREATED)
    public Gama save(@RequestBody Gama gama){
        return gamaApi.save(gama);
    }
}
