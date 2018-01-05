package com.easyrent.rentcarapp.service.impl;

import com.easyrent.rentcarapp.entity.Car;
import com.easyrent.rentcarapp.entity.Localization;
import com.easyrent.rentcarapp.entity.Reservation;
import com.easyrent.rentcarapp.repository.CarRepository;
import com.easyrent.rentcarapp.repository.ReservationRepository;
import com.easyrent.rentcarapp.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

@Service("reservationService")
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;
    @Autowired
    private CarRepository carRepository;

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

        allDaysInRequestedPeriod.removeIf(actualDay -> isAnyReservationOnThisDay(actualDay, reservationsForRequestedCar));

        return allDaysInRequestedPeriod;
    }

    @Override
    public void startNewReservation(Reservation reservation) {
        Car requestedCar = carRepository.findById(reservation.getCarId());
        requestedCar.setBooked(true);
        carRepository.save(requestedCar);

        reservation.setStartDate(getCurrentDate());
        reservationRepository.save(reservation);

    }

    @Override
    public void endReservation(Long reservationId, double latitude, double longitude) {
        Reservation reservation = reservationRepository.findById(reservationId);

        setReservationDataWhenEnds(reservation);
        setCarDataAfterReservation(reservation, latitude, longitude);
    }

    private void setReservationDataWhenEnds(Reservation reservation) {
        Date actualDate = getCurrentDate();
        reservation.setEndDate(actualDate);
        reservation.setPrice(calculatePrice(carRepository.findById(reservation.getCarId()),
                                            reservation.getStartDate(), actualDate));
        reservationRepository.save(reservation);
    }

    private void setCarDataAfterReservation(Reservation reservation, double latitude, double longitude) {
        Car requestedCar = carRepository.findById(reservation.getCarId());
        requestedCar.setBooked(false);
        requestedCar.setLocalization(getActualLocalization(latitude, longitude));
        carRepository.save(requestedCar);
    }

    private Localization getActualLocalization(double latitude, double longitude) {
        Localization currentLocalization = new Localization();
        currentLocalization.setLatitude(latitude);
        currentLocalization.setLongitude(longitude);
        return currentLocalization;
    }

    private BigDecimal calculatePrice(Car car, Date startDate, Date endDate) {
        long howManyMinutes = getMinutesFromSecond((endDate.getTime() - startDate.getTime()));
        return car.getPrice().multiply(new BigDecimal(howManyMinutes));
    }

    private long getMinutesFromSecond(long miliSeconds) {
        long minutes = miliSeconds / (60*1000);
        if (miliSeconds/1000 % 60 != 0)
            return ++minutes;
        return minutes;
    }


    private Date getCurrentDate() {
        Calendar c = Calendar.getInstance();
        return c.getTime();
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
