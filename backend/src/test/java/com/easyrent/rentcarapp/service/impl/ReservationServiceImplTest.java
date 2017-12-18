package com.easyrent.rentcarapp.service.impl;

import com.easyrent.rentcarapp.entity.Reservation;
import com.easyrent.rentcarapp.repository.ReservationRepository;
import com.easyrent.rentcarapp.service.ReservationService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class ReservationServiceImplTest {

    List<Reservation> reservations = Arrays.asList(
            new Reservation( 1, 1, new Date(), new Date(), new BigDecimal(123.123)),
            new Reservation( 1, 2, new Date(), new Date(), new BigDecimal(321.123)),
            new Reservation( 2, 3, new Date(), new Date(), new BigDecimal(123.321)),
            new Reservation( 3, 4, new Date(), new Date(), new BigDecimal(321.321))
    );

    @Mock
    private ReservationRepository repository;

    @InjectMocks
    ReservationService rs = new ReservationServiceImpl();

    @Test
    public void testFindAllReservations() {
        Mockito.when(rs.findAllReservations()).thenReturn(reservations);

        Assert.assertTrue(rs.findAllReservations().size() == reservations.size());
    }

    @Test
    public void testFindReservationById() {
        Reservation r = reservations.get(3);
        Mockito.when(rs.findReservationById(2L)).thenReturn(r);

        Reservation reservation = rs.findReservationById(2L);
        Assert.assertEquals(reservation.getUserId(), 3L);
    }


    @Test
    public void testFindByUserId() {
        List<Reservation> output = Arrays.asList(reservations.get(0), reservations.get(1));
        Mockito.when(rs.findByUserId(1L)).thenReturn(output);

        List<Reservation> result = rs.findByUserId(1L);
        Assert.assertEquals(result.size(), 2);
        Assert.assertEquals(result.get(0).getPrice(),new BigDecimal(123.123));
    }


    @Test
    public void testFindByCarId() {
        List<Reservation> output = Arrays.asList(reservations.get(2));
        Mockito.when(rs.findByCarId(3L)).thenReturn(output);

        List<Reservation> result = rs.findByCarId(3L);
        Assert.assertEquals(result.size(), 1);
        Assert.assertEquals(result.get(0).getUserId(), 2L);
    }
}
