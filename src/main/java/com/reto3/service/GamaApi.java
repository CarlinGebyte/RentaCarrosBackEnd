package com.reto3.service;

import com.reto3.modelo.Gama;
import com.reto3.repository.GamaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class GamaApi {
    /**
     * Inicializamos el repositorio Gama
     */
    @Autowired
    private GamaRepository gamaRepository;

    /**
     * Método para obtener todas las gamas del repositorio
     * @return
     */
    public List<Gama> getAll(){
        return gamaRepository.getAll();
    }

    /**
     * Método para obtener una gama por id
     * @param id
     * @return
     */
    public Optional<Gama> getGama(int id){
        return gamaRepository.getGama(id);
    }

    /**
     * Método para agregar una gama
     * @param gama
     * @return
     */
    public Gama save(Gama gama){
        if(gama.getIdGama()==null){
            return gamaRepository.save(gama);
        }else{
            Optional<Gama> evt=gamaRepository.getGama(gama.getIdGama());
            if(evt.isEmpty()){
                return gamaRepository.save(gama);
            }else{
                return gama;
            }
        }
    }
}
