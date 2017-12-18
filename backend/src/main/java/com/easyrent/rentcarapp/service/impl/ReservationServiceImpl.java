package com.easyrent.rentcarapp.service.impl;

import com.easyrent.rentcarapp.entity.Reservation;
import com.easyrent.rentcarapp.repository.ReservationRepository;
import com.easyrent.rentcarapp.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service("reservationService")
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    @Override
    public List<Reservation> findAllReservations() {
        return reservationRepository.findAll();
    }

    @Override
    public Reservation findReservationById(Long id) {
        return reservationRepository.findById(id);
    }

    @Override
    public List<Reservation> findByUserId(Long userId) {
        return reservationRepository.findByUserId(userId);
    }

    @Override
    public List<Reservation> findByCarId(Long reservationId) {
        return reservationRepository.findByCarId(reservationId);
    }

    @Override
    public void saveReservation(Reservation reservation)
    {
        reservationRepository.save(reservation);
    }

    @Override
    public void updateReservation(Reservation reservation)
    {
        reservationRepository.save(reservation);
    }

    @Override
    public void deleteReservationById(Long id) {
        reservationRepository.delete(id);
    }
}
