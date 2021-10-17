package com.reto3.service;

import com.reto3.modelo.Reservation;
import com.reto3.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationApi {
    /**
     * Inicializamos el Repositorio Reservation
     */
    @Autowired
    private ReservationRepository reservationRepository;

    /**
     * Método para obtener todas las reservaciones del repositorio
     * @return
     */
    public List<Reservation> getAll(){
        return  reservationRepository.getAll();
    }

    /**
     * Método para obtener una reservación por id
     * @param id
     * @return
     */
    public Optional<Reservation> getReservation(int id){
        return reservationRepository.getReservation(id);
    }

    /**
     * Método para agregar una reservación
     * @param reservation
     * @return
     */
    public Reservation save(Reservation reservation){
        if (reservation.getIdReservation() == null){
            return reservationRepository.save(reservation);
        }else{
            Optional<Reservation> evt = reservationRepository.getReservation(reservation.getIdReservation());
            if (evt.isEmpty()){
                return reservationRepository.save(reservation);
            }else{
                return reservation;
            }
        }
    }
}
