package com.easyrent.rentcarapp.controller;

import com.easyrent.rentcarapp.entity.Reservation;
import com.easyrent.rentcarapp.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

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
    @RequestMapping(value = "/reservations/user/{userId}", method = RequestMethod.GET)
    public List<Reservation> getReservationsByUserId(@PathVariable Long userId) {
        return reservationService.findByUserId(userId);
    }

    @CrossOrigin(origins = "http://localhost:8000")
    @RequestMapping(value = "/reservations/car/{carId}", method = RequestMethod.GET)
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
                                                 @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm") Date start,
                                                 @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm") Date end) {
        return reservationService.getReservationAvailability(car_id, start, end);
    }

    // Reservations for minutes

    @CrossOrigin(origins = "http://localhost:8000")
    @RequestMapping(value = "/reservations/start", method = RequestMethod.POST)
    public void startNewReservation(@RequestBody Reservation reservation) {
        reservationService.startNewReservation(reservation);
    }

    @CrossOrigin(origins = "http://localhost:8000")
    @RequestMapping(value = "/reservations/end", method = RequestMethod.POST)
    public void endReservation(@RequestBody Map<String, Object> payload) {
        reservationService.endReservation(Long.parseLong(String.valueOf(payload.get("id"))));
    }
}
