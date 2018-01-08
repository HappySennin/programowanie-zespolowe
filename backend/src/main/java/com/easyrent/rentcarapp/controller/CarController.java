package com.easyrent.rentcarapp.controller;

import com.easyrent.rentcarapp.entity.Car;
import com.easyrent.rentcarapp.entity.Localization;
import com.easyrent.rentcarapp.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
public class CarController {

    @Autowired
    private CarService carService;

    @CrossOrigin(origins = "http://localhost:8000")
    @RequestMapping(value = "/cars", method = RequestMethod.GET)
    public List<Car> getAllCars() {
        return carService.findAllCars();
    }

    @CrossOrigin(origins = "http://localhost:8000")
    @RequestMapping(value = "/cars/available", method = RequestMethod.GET)
    public List<Car> getAllAvailableCars() {
        return carService.findAllAvailableCars();
    }

    @CrossOrigin(origins = "http://localhost:8000")
    @RequestMapping(value = "/cars/id/{id}", method = RequestMethod.GET)
    public Car getCarById(@PathVariable Long id) {
        return carService.findCarById(id);
    }

    @CrossOrigin(origins = "http://localhost:8000")
    @RequestMapping(value = "/cars/brand/{brand}", method = RequestMethod.GET)
    public List<Car> getCarsByBrand(@PathVariable String brand) {
        return carService.findByBrandName(brand);
    }

    @CrossOrigin(origins = "http://localhost:8000")
    @RequestMapping(value = "/cars/model/{model}", method = RequestMethod.GET)
    public List<Car> getCarsByModel(@PathVariable String model) {
        return carService.findByModelName(model);
    }

    @CrossOrigin(origins = "http://localhost:8000")
    @RequestMapping(value = "/cars/type/{type}", method = RequestMethod.GET)
    public List<Car> getCarsByType(@PathVariable String type) {
        return carService.findByTypeName(type);
    }

    @CrossOrigin(origins = "http://localhost:8000")
    @RequestMapping(value = "/cars/power/{power}", method = RequestMethod.GET)
    public List<Car> getCarsByPower(@PathVariable String power) {
        return carService.findByPower(power);
    }

    @CrossOrigin(origins = "http://localhost:8000")
    @RequestMapping(value = "/cars/price/{price}", method = RequestMethod.GET)
    public List<Car> getCarsByPrice(@PathVariable BigDecimal price) {
        return carService.findByPrice(price);
    }

    @CrossOrigin(origins = "http://localhost:8000")
    @RequestMapping(value = "/cars", method = RequestMethod.PUT)
    public void updateCar(@RequestBody Car car) {
        carService.updateCar(car);
    }

    @CrossOrigin(origins = "http://localhost:8000")
    @RequestMapping(value = "/cars", method = RequestMethod.POST)
    public void insertNewCar(@RequestBody Car car) {
        carService.saveCar(car);
    }

    @CrossOrigin(origins = "http://localhost:8000")
    @RequestMapping(value = "/cars/{id}", method = RequestMethod.DELETE)
    public void deleteCarById(@RequestBody Long id) {
        carService.deleteCarById(id);
    }

    @CrossOrigin(origins = "http://localhost:8000")
    @RequestMapping(value = "/cars/location", method = RequestMethod.POST)
    public List<Car> getAvailableCarsByNearestLocation(@RequestBody Localization location) {
        return carService.getCarsByLocation(location);
    }
}
