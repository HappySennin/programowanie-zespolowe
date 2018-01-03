package com.easyrent.rentcarapp.service.impl;

import com.easyrent.rentcarapp.entity.Reservation;
import com.easyrent.rentcarapp.repository.ReservationRepository;
import com.easyrent.rentcarapp.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

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

    @Override
    public List<Date> getReservationAvailability(Long car_id, Date start, Date end) {

        List<Reservation> reservationsForRequestedCar = findByCarId(car_id);
        List<Date> allDaysInRequestedPeriod = createAllDaysInRequestedPeriod(start, end);

        Iterator<Date> allDaysInRequestedPeriodIterator = allDaysInRequestedPeriod.iterator();

        while (allDaysInRequestedPeriodIterator.hasNext()){
            Date actualDay = allDaysInRequestedPeriodIterator.next();

            if (isAnyReservationOnThisDay(actualDay, reservationsForRequestedCar))
                allDaysInRequestedPeriodIterator.remove();
        }

        return allDaysInRequestedPeriod;
    }

    private boolean isAnyReservationOnThisDay(Date actualDay, List<Reservation> reservationsForRequestedCar) {
        for (Reservation reservation : reservationsForRequestedCar){
            if (!reservation.getStartDate().after(actualDay) && !reservation.getEndDate().before(actualDay))
                return true;
        }
        return false;
    }

    private List<Date> createAllDaysInRequestedPeriod(Date start, Date end) {
        List<Date> allDaysInRequestedPeriod = new ArrayList<>();

        for (Date currentDay = start; currentDay.before(addOneDay(end)); currentDay=addOneDay(currentDay))
            allDaysInRequestedPeriod.add(currentDay);

        return allDaysInRequestedPeriod;
    }

    private Date addOneDay(Date currentDay) {
        Calendar c = Calendar.getInstance();
        c.setTime(currentDay);
        c.add(Calendar.DATE,1);
        return c.getTime();
    }
}
