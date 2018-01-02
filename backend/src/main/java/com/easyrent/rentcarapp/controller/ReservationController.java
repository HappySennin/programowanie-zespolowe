package com.easyrent.rentcarapp.controller;

import com.easyrent.rentcarapp.entity.Reservation;
import com.easyrent.rentcarapp.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @CrossOrigin(origins = "http://localhost:8000")
    @RequestMapping(value = "/reservations", method = RequestMethod.GET)
    public List<Reservation> findAllReservations() {
        return reservationService.findAllReservations();
    }

    @CrossOrigin(origins = "http://localhost:8000")
    @RequestMapping(value = "/reservations/id/{id}", method = RequestMethod.GET)
    public Reservation getReservationById(@PathVariable Long id) {
        return reservationService.findReservationById(id);
    }

    @CrossOrigin(origins = "http://localhost:8000")
    @RequestMapping(value = "/reservations/user/{user}", method = RequestMethod.GET)
    public List<Reservation> getReservationsByUserId(@PathVariable Long userId) {
        return reservationService.findByUserId(userId);
    }

    @CrossOrigin(origins = "http://localhost:8000")
    @RequestMapping(value = "/reservations/car/{car}", method = RequestMethod.GET)
    public List<Reservation> getReservationsByCarId(@PathVariable Long carId) {
        return reservationService.findByCarId(carId);
    }

    @CrossOrigin(origins = "http://localhost:8000")
    @RequestMapping(value = "/reservations", method = RequestMethod.PUT)
    public void updateReservation(@RequestBody Reservation reservation) {
        reservationService.updateReservation(reservation);
    }

    @CrossOrigin(origins = "http://localhost:8000")
    @RequestMapping(value = "/reservations", method = RequestMethod.POST)
    public void insertNewReservation(@RequestBody Reservation reservation) {
        reservationService.saveReservation(reservation);
    }

    @CrossOrigin(origins = "http://localhost:8000")
    @RequestMapping(value = "/reservations/{id}", method = RequestMethod.DELETE)
    public void deleteReservationById(@RequestBody Long id) {
        reservationService.deleteReservationById(id);
    }

    @CrossOrigin(origins = "http://localhost:8000")
    @RequestMapping(value = "/reservations/car/{car_id}/start/{start}/end/{end}", method = RequestMethod.GET)
    public List<Date> getReservationAvailability(@PathVariable Long car_id,
                                                 @PathVariable @DateTimeFormat(pattern = "dd-MM-yyyy") Date start,
                                                 @PathVariable @DateTimeFormat(pattern = "dd-MM-yyyy") Date end) {
        return reservationService.getReservationAvailability(car_id, start, end);
    }
}