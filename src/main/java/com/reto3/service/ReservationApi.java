package com.reto3.service;

import com.reto3.modelo.Client;
import com.reto3.modelo.Reservation;
import com.reto3.repository.ClientRepository;
import com.reto3.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ReservationApi {
    /**
     * Inicializamos el Repositorio Reservation
     */
    @Autowired
    private ReservationRepository reservationRepository;

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
     * @param id
     * @return
     */
    public Optional<Reservation> getReservation(int id) {
        return reservationRepository.getReservation(id);
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
     * @param id
     * @return
     */
    public boolean delete(int id) {
        Boolean flag = getReservation(id).map(reservation -> {
            reservationRepository.delete(reservation);
            return true;
        }).orElse(false);
        return flag;
    }

    /**
     * Método para buscar reservaciones en una selección por fechas
     * @param from
     * @param to
     * @return
     */
    public ArrayList<Reservation> getByDate(Date from, Date to) {

        List<Reservation> reservations = reservationRepository.getAll();
        ArrayList<Reservation> dateReservation = new ArrayList<>();
        int count = 0;

        for (Reservation reservation : reservations) {
            if(from.compareTo(to) < 0) {
                if (reservation.getDevolutionDate().compareTo(from) > 0 && reservation.getStartDate().compareTo(to) < 0) {
                    if ((reservation.getStartDate().compareTo(from) <= 0 || reservation.getStartDate().compareTo(from) >= 0) &&
                            reservation.getDevolutionDate().compareTo(to) <= 0 || reservation.getDevolutionDate().compareTo(to) >= 0) {
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
    public HashMap<String, Integer> getVs(){
        List<Reservation> reservations = reservationRepository.getAll();
        HashMap<String, Integer> status = new HashMap<>();
        int completed = 0;
        int cancelled = 0;
        for (Reservation reservation : reservations){
            if (reservation.getStatus().toLowerCase().equals("completed")){
                completed++;
            }else if (reservation.getStatus().toLowerCase().equals("cancelled")){
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
                if (reservation.getStatus().toLowerCase().equals("completed")) {
                    total++;
                }
            }
            reportClient.put("total", total);
            reportClient.put("client",client);
            countClients.add(reportClient.clone());
            System.out.println(countClients);
        }
        return countClients;
    }
}
