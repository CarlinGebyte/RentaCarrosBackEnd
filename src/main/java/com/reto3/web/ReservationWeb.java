package com.reto3.web;

import com.reto3.modelo.Reservation;
import com.reto3.service.ReservationApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RequestMapping("/Reservation/")
public class ReservationWeb {
    @Autowired
    private ReservationApi reservationApi;

    @GetMapping("all")
    public List<Reservation> getAll(){
        return reservationApi.getAll();
    }

    @GetMapping("{id}")
    public Optional<Reservation> getReservation(@PathVariable("id") int id){
        return reservationApi.getReservation(id);
    }

    @PostMapping("save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation save(@RequestBody Reservation reservation){
        return reservationApi.save(reservation);
    }
}
