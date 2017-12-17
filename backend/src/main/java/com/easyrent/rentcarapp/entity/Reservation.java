package com.easyrent.rentcarapp.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Getter
@Setter

public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private long userId;
    private long carId;
    @DateTimeFormat(pattern="dd.MM.yyyy hh:mm")
    private Date startDate;
    @DateTimeFormat(pattern="dd.MM.yyyy hh:mm")
    private Date endDate;
    private BigDecimal price;

    @Override
    public String toString() {
        return "userId=" + userId + ", carId=" + carId + ", startDate=" + startDate + ", endDate=" + endDate
                +", price=$" + price;
    }
}
