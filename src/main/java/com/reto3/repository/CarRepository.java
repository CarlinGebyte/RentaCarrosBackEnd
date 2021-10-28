package com.reto3.repository;

import com.reto3.modelo.Carros;
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
     *
     * @return
     */
    public List<Carros> getAll() {
        return (List<Carros>) carCrudRepository.findAll();
    }

    /**
     * Método para encontrar un carro por id
     *
     * @param id
     * @return
     */
    public Optional<Carros> getCar(int id) {
        return carCrudRepository.findById(id);
    }

    /**
     * Método para agregar un carro nuevo
     *
     * @param carros
     * @return
     */
    public Carros save(Carros carros) {
        return carCrudRepository.save(carros);
    }

    /**
     * Método para eliminar un carro
     *
     * @param carros
     */
    public void delete(Carros carros) {
        carCrudRepository.delete(carros);
    }
}
