package com.easyrent.rentcarapp.controller;

import com.easyrent.rentcarapp.entity.Car;
import com.easyrent.rentcarapp.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
public class CarController {

    @Autowired
    private CarService carService;

    @RequestMapping(value = "/cars", method = RequestMethod.GET)
    public List<Car> getAllCars() {
        return carService.findAllCars();
    }

    @RequestMapping(value = "/cars/id/{id}", method = RequestMethod.GET)
    public Car getCarById(@PathVariable Long id) {
        return carService.findCarById(id);
    }

    @RequestMapping(value = "/cars/brand/{brand}", method = RequestMethod.GET)
    public List<Car> getCarsByBrand(@PathVariable String brand) {
        return carService.findByBrandName(brand);
    }

    @RequestMapping(value = "/cars/model/{model}", method = RequestMethod.GET)
    public List<Car> getCarsByModel(@PathVariable String model) {
        return carService.findByModelName(model);
    }

    @RequestMapping(value = "/cars/type/{type}", method = RequestMethod.GET)
    public List<Car> getCarsByType(@PathVariable String type) {
        return carService.findByTypeName(type);
    }

    @RequestMapping(value = "/cars/power/{power}", method = RequestMethod.GET)
    public List<Car> getCarsByPower(@PathVariable String power) {
        return carService.findByPower(power);
    }

    @RequestMapping(value = "/cars/price/{price}", method = RequestMethod.GET)
    public List<Car> getCarsByPrice(@PathVariable BigDecimal price) {
        return carService.findByPrice(price);
    }

    @RequestMapping(value = "/cars", method = RequestMethod.PUT)
    public void updateCar(@RequestBody Car car) {
        carService.updateCar(car);
    }

    @RequestMapping(value = "/cars", method = RequestMethod.POST)
    public void insertNewCar(@RequestBody Car car) {
        carService.saveCar(car);
    }

    @RequestMapping(value = "/cars/{id}", method = RequestMethod.DELETE)
    public void deleteCarById(@RequestBody Long id) {
        carService.deleteCarById(id);
    }

}
