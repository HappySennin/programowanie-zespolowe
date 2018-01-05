package com.easyrent.rentcarapp.service;

import com.easyrent.rentcarapp.entity.Car;

import java.math.BigDecimal;
import java.util.List;

public interface CarService {

    List<Car> findAllCars();

    Car findCarById(Long id);

    List<Car> findByBrandName(String brand);

    List<Car> findByModelName(String model);

    List<Car> findByTypeName(String name);

    List<Car> findByPower(String power);

    List<Car> findByPrice(BigDecimal price);

    List<Car> findAllAvailableCars();

    void saveCar(Car car);

    void updateCar(Car car);

    void deleteCarById(Long id);
}
