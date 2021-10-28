package com.reto3.web;

import com.reto3.modelo.Client;
import com.reto3.modelo.Reservation;
import com.reto3.service.ReservationApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("/api/Reservation/")
public class ReservationWeb {
    /**
     * Inicializamos API Reservation
     */
    @Autowired
    private ReservationApi reservationApi;

    /**
     * Método para obtener todas las reservaciones por URL
     *
     * @return
     */
    @GetMapping("all")
    public List<Reservation> getAll() {
        return reservationApi.getAll();
    }

    /**
     * Método para obtener todas las reservaciones en una fecha específica
     *
     * @return
     */
    @GetMapping("report-dates/{from}/{to}")
    public List<Reservation> getByDate(@PathVariable("from") String sFrom, @PathVariable("to") String sTo){
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        Date from = null;
        Date to = null;
        try {
            from = formato.parse(sFrom);
            to = formato.parse(sTo);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return reservationApi.getByDate(from, to);
    }

    /**
     * Método para obtener el conteo las reservas completas de cada cliente
     * @return
     */
    @GetMapping("report-clients")
    public List<Object> getClientReport(){
        return reservationApi.getClientReport();
    }

    /**
     * Método para obtener el mapeo para retornar el conteo de reservas completas vs canceladas
     * @return
     */
    @GetMapping("report-status")
    public HashMap<String, Integer> getVs(){
        return reservationApi.getVs();
    }
    /**
     * Método para obtener una reservación por id desde URL
     *
     * @param id
     * @return
     */
    @GetMapping("{id}")
    public Optional<Reservation> getReservation(@PathVariable("id") int id) {
        return reservationApi.getReservation(id);
    }

    /**
     * Método para agregar una reservación por URL
     *
     * @param reservation
     * @return
     */
    @PostMapping("save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation save(@RequestBody Reservation reservation) {
        return reservationApi.save(reservation);
    }

    /**
     * Método para actualizar una reservación
     * @param reservation
     * @return
     */
    @PutMapping("update")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation update(@RequestBody Reservation reservation) {
        return reservationApi.update(reservation);
    }

    /**
     * Método para elimiar una reservación
     * @param id
     * @return
     */
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id) {
        return reservationApi.delete(id);
    }
}
