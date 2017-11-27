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
    private ReservationRepository carRepository;

    @Override
    public List<Reservation> findAllReservations() {
        return ReservationRepository.findAllReservations();
    }

    @Override
    public Reservation findReservationById(Long id) {
        return ReservationRepository.findReservationById(id);
    }

    @Override
    public List<Reservation> findByUserId(Long userId) {
        return ReservationRepository.findByUserId(userId);
    }

    @Override
    public List<Reservation> findByCarId(Long carId) {
        return ReservationRepository.findByCarId(Long carId);
    }

    @Override
    public void deleteReservationById(Long id) {
        ReservationRepository.delete(id);
    }
}
