package com.reto3.web;

import com.reto3.modelo.Carros;
import com.reto3.service.CarApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RequestMapping("/api/Car/")
public class CarWeb {
    /**
     * Inicializamos el Api Car
     */
    @Autowired
    private CarApi carApi;

    /**
     * Método para obtener los carros por URL
     * @return
     */
    @GetMapping("all")
    public List<Carros> getCar(){
        return carApi.getAll();
    }

    /**
     * Método para obtener un carro por id desde URL
     * @param id
     * @return
     */
    @GetMapping("{id}")
    public Optional<Carros> getCar(@PathVariable("id") int id){
        return carApi.getCar(id);
    }

    /**
     * Método para agregar un carro desde URL
     * @param carros
     * @return
     */
    @PostMapping("save")
    @ResponseStatus(HttpStatus.CREATED)
    public Carros save(@RequestBody Carros carros){
        return carApi.save(carros);
    }

   @PutMapping("update")
    @ResponseStatus(HttpStatus.CREATED)
    public Carros update(@RequestBody Carros carros){
        return carApi.update(carros);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id){
        return carApi.delete(id);
    }
}
