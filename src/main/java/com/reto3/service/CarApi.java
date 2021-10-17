package com.reto3.service;

import com.reto3.modelo.Car;
import com.reto3.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CarApi {
    /**
     * Inicializamos el repositorio
     */
    @Autowired
    private CarRepository carRepository;

    /**
     * Método para obtener todos los carros del repositorio
     * @return
     */
    public List<Car> getAll(){
        return carRepository.getAll();
    }

    /**
     * Método para obtener un carro por id
     * @param id
     * @return
     */
    public Optional<Car> getCar(int id){
        return carRepository.getCar(id);
    }

    /**
     * Método para agregar un carro
     * @param car
     * @return
     */
    public Car save(Car car){
        if(car.getIdCar()==null){
            return carRepository.save(car);
        }else{
            Optional<Car> evt = carRepository.getCar(car.getIdCar());
            if(evt.isEmpty()){
                return carRepository.save(car);
            }else{
                return car;
            }
        }
    }
}
