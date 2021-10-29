package com.reto3.service;

import com.reto3.modelo.Client;
import com.reto3.modelo.Reservation;
import com.reto3.repository.ClientRepository;
import com.reto3.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author CarlinGebyte
 */
@Service
public class ReservationApi {
    /**
     * Inicializamos el Repositorio Reservation
     */
    @Autowired
    private ReservationRepository reservationRepository;

    /**
     * Inicializamos el Repositorio Client
     */
    @Autowired
    private ClientRepository clientRepository;

    /**
     * Método para obtener todas las reservaciones del repositorio
     *
     * @return
     */
    public List<Reservation> getAll() {
        return reservationRepository.getAll();
    }

    /**
     * Método para obtener una reservación por id
     *
     * @param idReservation
     * @return
     */
    public Optional<Reservation> getReservation(int idReservation) {
        return reservationRepository.getReservation(idReservation);
    }

    /**
     * Método para agregar una reservación
     *
     * @param reservation
     * @return
     */
    public Reservation save(Reservation reservation) {
        if (reservation.getIdReservation() == null) {
            return reservationRepository.save(reservation);
        } else {
            Optional<Reservation> evt = reservationRepository.getReservation(reservation.getIdReservation());
            if (evt.isEmpty()) {
                return reservationRepository.save(reservation);
            } else {
                return reservation;
            }
        }
    }

    /**
     * Método para actualizar una reservación
     *
     * @param reservation
     * @return
     */
    public Reservation update(Reservation reservation) {
        if (reservation.getIdReservation() != null) {
                Optional<Reservation> evnt = reservationRepository.getReservation(reservation.getIdReservation());
            if (!evnt.isEmpty()) {
                if (reservation.getStartDate() != null) {
                    evnt.get().setStartDate(reservation.getStartDate());
                }
                if (reservation.getDevolutionDate() != null) {
                    evnt.get().setDevolutionDate(reservation.getDevolutionDate());
                }
                if (reservation.getStatus() != null) {
                    evnt.get().setStatus(reservation.getStatus());
                }
                reservationRepository.save(evnt.get());
                return evnt.get();
            } else {
                return reservation;
            }
        } else {
            return reservation;
        }
    }

    /**
     * Método para eliminar una reservación
     *
     * @param idReservation
     * @return
     */
    public boolean delete(int idReservation) {
        return getReservation(idReservation).map(reservation -> {
            reservationRepository.delete(reservation);
            return true;
        }).orElse(false);
    }

    /**
     * Método para buscar reservaciones en una selección por fechas
     * @param from
     * @param until
     * @return
     */
    public ArrayList<Reservation> getByDate(Date from, Date until) {

        List<Reservation> reservations = reservationRepository.getAll();
        ArrayList<Reservation> dateReservation = new ArrayList<>();
        int count = 0;

        for (Reservation reservation : reservations) {
            if(from.compareTo(until) < 0) {
                if (reservation.getDevolutionDate().compareTo(from) > 0 && reservation.getStartDate().compareTo(until) < 0) {
                    if ((reservation.getStartDate().compareTo(from) <= 0 || reservation.getStartDate().compareTo(from) >= 0) &&
                            reservation.getDevolutionDate().compareTo(until) <= 0 || reservation.getDevolutionDate().compareTo(until) >= 0) {
                        count++;
                        dateReservation.add(reservation);

                        System.out.println(dateReservation.size());
                    }
                }
            }
        }

        return dateReservation;
    }

    /**
     * Método para obtener la cantidad de reservas completadas y canceladas
     * @return
     */
    public LinkedHashMap<String, Integer> getVs(){
        List<Reservation> reservations = reservationRepository.getAll();
        LinkedHashMap<String, Integer> status = new LinkedHashMap<>();
        int completed = 0;
        int cancelled = 0;
        for (Reservation reservation : reservations){
            if ("completed".equals(reservation.getStatus().toLowerCase())){
                completed++;
            }else if ("cancelled".equals(reservation.getStatus().toLowerCase())){
                cancelled++;
            }
        }
        status.put("completed", completed);
        status.put("cancelled", cancelled);
        return  status;
    }

    /**
     * Método para obtener la cantidad de reservas completadas de un cliente
     * @return
     */
    public List<Object> getClientReport(){
        List<Client> clients = clientRepository.getAll();
        LinkedHashMap<String,Object> reportClient = new LinkedHashMap<>();
        List<Object> countClients = new ArrayList<>();
        for (Client client: clients){
            Integer total = 0;
            for (Reservation reservation : client.getReservations()) {
                    total++;
            }
            reportClient.put("total", total);
            reportClient.put("client",client);
            countClients.add(reportClient.clone());
            System.out.println(countClients);
            System.out.println(reportClient);
        }
        return countClients;
    }
}
