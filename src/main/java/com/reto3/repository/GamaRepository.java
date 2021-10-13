package com.reto3.repository;

import com.reto3.modelo.Gama;
import com.reto3.repository.crud.GamaCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class GamaRepository {
    /**
     * Atributo Repositorio Gama
     */
    @Autowired
    private GamaCrudRepository gamaCrudRepository;

    /**
     * Método para obtener todas las gamas del repositorio
     * @return
     */
    public List<Gama> getAll(){
        return (List<Gama>) gamaCrudRepository.findAll();
    }

    /**
     * Método para buscar una gama por id
     * @param id
     * @return
     */
    public Optional<Gama> getGama(int id){
        return gamaCrudRepository.findById(id);
    }

    /**
     * Método para agregar una gama
     * @param gama
     * @return
     */
    public Gama save(Gama gama){
        return gamaCrudRepository.save(gama);
    }
}
