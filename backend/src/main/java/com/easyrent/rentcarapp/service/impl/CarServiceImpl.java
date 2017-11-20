package com.easyrent.rentcarapp.service.impl;

import com.easyrent.rentcarapp.entity.Car;
import com.easyrent.rentcarapp.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.easyrent.rentcarapp.repository.CarRepository;

import java.math.BigDecimal;
import java.util.List;

@Service("carService")
public class CarServiceImpl implements CarService {

    @Autowired
    private CarRepository carRepository;

    @Override
    public List<Car> findAllCars() {
        return carRepository.findAll();
    }

    @Override
    public Car findCarById(Long id) {
        return carRepository.findById(id);
    }

    @Override
    public List<Car> findByBrandName(String brand) {
        return carRepository.findByBrandName(brand);
    }

    @Override
    public List<Car> findByModelName(String model) {
        return carRepository.findByModelName(model);
    }

    @Override
    public List<Car> findByTypeName(String name) {
        return carRepository.findByTypeName(name);
    }

    @Override
    public List<Car> findByPower(String power) {
        return carRepository.findByPower(power);
    }

    @Override
    public List<Car> findByPrice(BigDecimal price){
        return carRepository.findByPrice(price);
    }

    @Override
    public void saveCar(Car car) {
        carRepository.save(car);
    }

    @Override
    public void updateCar(Car car) {
        carRepository.save(car);
    }

    @Override
    public void deleteCarById(Long id) {
        carRepository.delete(id);
    }
}
