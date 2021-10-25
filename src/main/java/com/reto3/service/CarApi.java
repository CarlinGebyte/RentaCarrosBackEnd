package com.reto3.service;

import com.reto3.modelo.Carros;
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
    public List<Carros> getAll(){
        return carRepository.getAll();
    }

    /**
     * Método para obtener un carro por id
     * @param id
     * @return
     */
    public Optional<Carros> getCar(int id){
        return carRepository.getCar(id);
    }

    /**
     * Método para agregar un carro
     * @param carros
     * @return
     */
    public Carros save(Carros carros){
        if(carros.getIdCar()==null){
            return carRepository.save(carros);
        }else{
            Optional<Carros> evt = carRepository.getCar(carros.getIdCar());
            if(evt.isEmpty()){
                return carRepository.save(carros);
            }else{
                return carros;
            }
        }
    }

    /**
     * Método para actualizar carro
     * @param carros
     * @return
     */
    public Carros update(Carros carros){
        if (carros.getIdCar() != null){
            Optional<Carros> actualizar = carRepository.getCar(carros.getIdCar());
            if (!actualizar.isEmpty()){
                if (carros.getName() != null){
                actualizar.get().setName(carros.getName());
                }
                if (carros.getBrand() != null){
                    actualizar.get().setBrand(carros.getBrand());
                }
                if (carros.getYear() != 0){
                    actualizar.get().setYear(carros.getYear());
                }
                if (carros.getDescription() != null){
                    actualizar.get().setDescription(carros.getDescription());
                }
                carRepository.save(actualizar.get());
                return actualizar.get();
            }else{
                return carros;
            }
        }else{
            return carros;
        }
    }

    /**
     * Método para eliminar un carro
     * @param id
     * @return
     */
    public boolean delete(int id){
        Boolean flag = getCar(id).map(car -> {
            carRepository.delete(car);
            return true;
        }).orElse(false);
        return flag;
    }
}
