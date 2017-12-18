package com.easyrent.rentcarapp.service.impl;

import com.easyrent.rentcarapp.entity.Car;
import com.easyrent.rentcarapp.repository.CarRepository;
import com.easyrent.rentcarapp.service.CarService;
import com.easyrent.rentcarapp.service.impl.CarServiceImpl;
import org.hibernate.SessionFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@RunWith(MockitoJUnitRunner.class)
public class CarServiceImplTest
{
    List<Car> cars = Arrays.asList(
                        new Car( "brand1", "model1", "type1", "power1", new BigDecimal(123.123)),
                        new Car( "brand2", "model2", "type2", "power2", new BigDecimal(321.123)),
                        new Car( "brand3", "model3", "type3", "power3", new BigDecimal(123.321)));
    @InjectMocks
    private CarService carService = new CarServiceImpl();
    @Mock
    private CarRepository carRepository;

    @Test
    public void testMockCreation(){
        assertNotNull(carService);
        assertNotNull(carRepository);
    }
    @Test
    public void testMockFindAllCar(){
        Mockito.when(carService.findAllCars()).thenReturn(cars);

        Assert.assertTrue(carRepository.findAll().size() == cars.size());
    }
    @Test
    public void testMockFfindCarById(){
        Car c = cars.get(2);
        Mockito.when(carService.findCarById(1L)).thenReturn(c);

        Car car = carService.findCarById(1L);
        Assert.assertEquals("brandName=brand3, modelName=model3, typeName=type3, power=power3, price=$123.320999999999997953636921010911464691162109375", car.toString());
    }
    @Test
    public void testMockFindByBrandName(){
        ArrayList<Car> kars = new ArrayList<>();
        for ( Car car:cars)
        {
            if (Objects.equals(car.getBrandName(), "brand2"))
            {
                kars.add(car);
            }
        }
        Mockito.when(carService.findByBrandName("brand2")).thenReturn(kars);

        List<Car> kars2 = carService.findByBrandName("brand2");
        Assert.assertEquals(kars, kars2);
    }
    @Test
    public void testMockFindByModelName(){
        ArrayList<Car> kars = new ArrayList<>();
        for ( Car car:cars)
        {
            if (Objects.equals(car.getModelName(), "model2"))
            {
                kars.add(car);
            }
        }
        Mockito.when(carService.findByBrandName("model2")).thenReturn(kars);

        List<Car> kars2 = carService.findByBrandName("model2");
        Assert.assertEquals(kars, kars2);
    }
    @Test
    public void testMockFindByTypeName(){
        ArrayList<Car> kars = new ArrayList<>();
        for ( Car car:cars)
        {
            if (Objects.equals(car.getTypeName(), "type3"))
            {
                kars.add(car);
            }
        }
        Mockito.when(carService.findByBrandName("type3")).thenReturn(kars);

        List<Car> kars2 = carService.findByBrandName("type3");
        Assert.assertEquals(kars, kars2);
    }
    @Test
    public void testMockFindByPower(){
        ArrayList<Car> kars = new ArrayList<>();
        for ( Car car:cars)
        {
            if (Objects.equals(car.getPower(), "power1"))
            {
                kars.add(car);
            }
        }
        Mockito.when(carService.findByBrandName("power1")).thenReturn(kars);

        List<Car> kars2 = carService.findByBrandName("power1");
        Assert.assertEquals(kars, kars2);
    }
    @Test
    public void testMockFindByPrice(){
        ArrayList<Car> kars = new ArrayList<>();
        for ( Car car:cars)
        {
            if (Objects.equals(car.getPrice(), new BigDecimal(123.321)))
            {
                kars.add(car);
            }
        }
        Mockito.when(carService.findByBrandName("price3")).thenReturn(kars);

        List<Car> kars2 = carService.findByBrandName("price3");
        Assert.assertEquals(kars, kars2);
    }

}
