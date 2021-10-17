package com.reto3.repository;

import com.reto3.modelo.Car;
import com.reto3.repository.crud.CarCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public class CarRepository {
    /**
     * Atributo Repositorio Car
     */
    @Autowired
    private CarCrudRepository carCrudRepository;

    /**
     * Método para encontrar todos los carros del repositorio
     * @return
     */
    public List<Car> getAll(){
        return (List<Car>) carCrudRepository.findAll();
    }

    /**
     * Método para encontrar un carro por id
     * @param id
     * @return
     */
    public Optional<Car> getCar(int id){
        return carCrudRepository.findById(id);
    }

    /**
     * Método para agregar un carro nuevo
     * @param car
     * @return
     */
    public Car save(Car car){
        return carCrudRepository.save(car);
    }
}
