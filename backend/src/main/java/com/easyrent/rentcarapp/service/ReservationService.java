package com.easyrent.rentcarapp.service;

import com.easyrent.rentcarapp.entity.Reservation;

import java.util.Date;
import java.util.List;

public interface ReservationService {

    List<Reservation> findAllReservations();

    Reservation findReservationById(Long id);

    List<Reservation> findByUserId(Long userId);

    List<Reservation> findByCarId(Long carId);

    void saveReservation(Reservation reservation);

    void updateReservation(Reservation reservation);

    void deleteReservationById(Long reservation);

    List<Date> getReservationAvailability(Long car_id, Date start, Date end);

    void startNewReservation(Reservation reservation);

    void endReservation(Long reservationId);
}
