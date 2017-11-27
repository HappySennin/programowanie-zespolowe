package com.easyrent.rentcarapp.controller;

import com.easyrent.rentcarapp.entity.Reservation;
import com.easyrent.rentcarapp.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @RequestMapping(value = "/reservations", method = RequestMethod.GET)
    public List<Reservation> findAllReservations() { return reservationService.findAllReservations(); }


}



