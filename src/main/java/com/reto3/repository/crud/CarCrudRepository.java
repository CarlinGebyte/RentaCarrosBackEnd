package com.reto3.repository.crud;

import com.reto3.modelo.Car;
import org.springframework.data.repository.CrudRepository;

public interface CarCrudRepository extends CrudRepository<Car,Integer> {
}
