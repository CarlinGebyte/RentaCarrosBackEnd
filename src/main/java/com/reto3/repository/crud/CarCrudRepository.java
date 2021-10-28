package com.reto3.repository.crud;

import com.reto3.modelo.Carros;
import org.springframework.data.repository.CrudRepository;

public interface CarCrudRepository extends CrudRepository<Carros, Integer> {
}
