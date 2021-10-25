package com.reto3.repository;

import com.reto3.modelo.Reservation;
import com.reto3.repository.crud.ReservationCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public class ReservationRepository {
    /**
     * Atributo Repositorio Reervation
     */
    @Autowired
    private ReservationCrudRepository reservationRepository;

    /**
     * Método para obtener todas las reservaciones
     * @return
     */
    public List<Reservation> getAll(){
        return (List<Reservation>) reservationRepository.findAll();
    }

    /**
     * Método para buscar una reservación por id
     * @param id
     * @return
     */
    public Optional<Reservation> getReservation(int id){
        return reservationRepository.findById(id);
    }

    /**
     * Método para agregar una reservación
     * @param reservation
     * @return
     */
    public Reservation save(Reservation reservation){
        return reservationRepository.save(reservation);
    }

    public void delete(Reservation reservation){
        reservationRepository.delete(reservation);
    }
}
