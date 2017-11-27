package com.easyrent.rentcarapp.repository;

import com.easyrent.rentcarapp.entity.Car;
import com.easyrent.rentcarapp.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findAllReservations();
    Reservation findReservationById(Long id);
    List<Reservation> findByUserId(Long userId);
    List<Reservation> findByCarId(Long carId);

}
