package com.reto3.service;

import com.reto3.modelo.Gama;
import com.reto3.repository.GamaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GamaApi {
    @Autowired
    private GamaRepository gamaRepository;

    public List<Gama> getAll(){
        return gamaRepository.getAll();
    }

    public Optional<Gama> getGama(int id){
        return gamaRepository.getGama(id);
    }

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
