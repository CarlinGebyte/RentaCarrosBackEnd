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

    /**
     * Método para actualizar una reservación
     * @param reservation
     * @return
     */
    public Reservation update(Reservation reservation){
        if (reservation.getIdReservation() != null){
            Optional<Reservation> evnt = reservationRepository.getReservation(reservation.getIdReservation());
            if (!evnt.isEmpty()){
                if (reservation.getStartDate() != null){
                    evnt.get().setStartDate(reservation.getStartDate());
                }
                if (reservation.getDevolutionDate() != null){
                    evnt.get().setDevolutionDate(reservation.getDevolutionDate());
                }
                if (reservation.getStatus() != null){
                    evnt.get().setStatus(reservation.getStatus());
                }
                reservationRepository.save(evnt.get());
                return evnt.get();
            }else{
                return reservation;
            }
        }else{
            return reservation;
        }
    }

    /**
     * Método para eliminar una reservación
     * @param id
     * @return
     */
    public boolean delete(int id){
        Boolean flag = getReservation(id).map(reservation -> {
            reservationRepository.delete(reservation);
            return true;
        }).orElse(false);
        return flag;
    }
}
