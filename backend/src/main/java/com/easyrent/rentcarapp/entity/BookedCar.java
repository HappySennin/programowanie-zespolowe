package com.easyrent.rentcarapp.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

public class BookedCar
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long id_Car;
    private Date from;
    private Date to;
    private long id_user;

    public long getId_Car()
    {
        return id_Car;
    }

    public void setId_Car(long id_Car)
    {
        this.id_Car = id_Car;
    }

    public Date getFrom()
    {
        return from;
    }

    public void setFrom(Date from)
    {
        this.from = from;
    }

    public Date getTo()
    {
        return to;
    }

    public void setTo(Date to)
    {
        this.to = to;
    }

    public long getId_user()
    {
        return id_user;
    }

    public void setId_user(long id_user)
    {
        this.id_user = id_user;
    }

    public long getId()

    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    @Override
    public String toString() {
        return "id_Car=" +id_Car + ", booked from=" + from + ", to=" + to + ", by=" + id_user;
    }
}
