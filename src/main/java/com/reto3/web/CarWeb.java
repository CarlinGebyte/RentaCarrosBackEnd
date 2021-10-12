package com.reto3.web;

import com.reto3.modelo.Car;
import com.reto3.service.CarApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RequestMapping("/Car/")
public class CarWeb {
    @Autowired
    private CarApi carApi;

    @GetMapping("all")
    public List<Car> getCar(){
        return carApi.getAll();
    }

    @GetMapping("{id}")
    public Optional<Car> getCar(@PathVariable("id") int id){
        return carApi.getCar(id);
    }
    @PostMapping("save")
    @ResponseStatus(HttpStatus.CREATED)
    public Car save(@RequestBody Car car){
        return carApi.save(car);
    }
}
