package com.easyrent.rentcarapp.entity;

import lombok.AllArgsConstructor;
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

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public long getUserId()
    {
        return userId;
    }

    public void setUserId(long userId)
    {
        this.userId = userId;
    }

    public long getCarId()
    {
        return carId;
    }

    public void setCarId(long carId)
    {
        this.carId = carId;
    }

    public Date getStartDate()
    {
        return startDate;
    }

    public void setStartDate(Date startDate)
    {
        this.startDate = startDate;
    }

    public Date getEndDate()
    {
        return endDate;
    }

    public void setEndDate(Date endDate)
    {
        this.endDate = endDate;
    }

    public BigDecimal getPrice()
    {
        return price;
    }

    public void setPrice(BigDecimal price)
    {
        this.price = price;
    }

    public Reservation(long userId, long carId, Date startDate, Date endDate, BigDecimal price) {
        this.userId = userId;
        this.carId = carId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.price = price;

    }

    @Override
    public String toString() {
        return "userId=" + userId + ", carId=" + carId + ", startDate=" + startDate + ", endDate=" + endDate
                +", price=$" + price;
    }
}
