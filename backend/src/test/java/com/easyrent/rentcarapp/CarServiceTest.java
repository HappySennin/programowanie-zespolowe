package com.easyrent.rentcarapp;

import com.easyrent.rentcarapp.entity.Car;
import com.easyrent.rentcarapp.repository.CarRepository;
import com.easyrent.rentcarapp.service.CarService;
import com.easyrent.rentcarapp.service.impl.CarServiceImpl;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;

public class CarServiceTest
{
    @Mock
    private CarServiceImpl carService;
    @Mock
    private Car car;
    @Mock
    private CarRepository carRepository;
    @Before
    public void setupMock() {
        MockitoAnnotations.initMocks(this);
    }
    /*@Before
     public void initTable()
     {
         Car car = new Car();
         carService.saveCar(car);
         carService.saveCar(car);
         carService.saveCar(car);
     }*/
    @Test
    public void testMockCreation(){
        assertNotNull(carService);
        assertNotNull(car);
        assertNotNull(carRepository);
    }
    @Test
    public void testMockFindAllCar(){
        System.out.printf("" + carService.findAllCars().size());
        assertEquals(14 , carService.findAllCars().size()); // tak nie powinno byc4
    }
    @Test
    public void testMockFfindCarById(){
        assertEquals("brandName=Mazda, modelName=Mazda 6, typeName=Sedan, power=184 HP, price=$450.00" , carService.findCarById((long) 1).toString()); // tak nie powinno byc4
    }
    @Test
    public void testMockFindByBrandName(){
        assertFalse(carService.findByModelName("Audi").isEmpty()); // tak nie powinno byc4
    }
    @Test
    public void testMockFindByModelName(){
        assertFalse(carService.findByModelName("Mazda 6").isEmpty()); // tak nie powinno byc4
    }
    @Test
    public void testMockFindByTypeName(){
        assertFalse(carService.findByModelName("Truck").isEmpty()); // tak nie powinno byc4
    }
    @Test
    public void testMockFindByPower(){
        assertEquals(1 , carService.findByPower("180 HP").size()); // tak nie powinno byc4
    }
    @Test
    public void testMockFindByPrice(){
        assertEquals(1 , carService.findByPrice(BigDecimal.valueOf(450.00)).size()); // tak nie powinno byc4
    }
    @Test
    public void testMockSaveCar(){
        System.out.printf("" + carService.findAllCars().size());
        assertEquals(15 , carService.findAllCars().size()); // tak nie powinno byc4
    }
    @Test
    public void testMockUpdateCar(){
        long oldSize = carService.findAllCars().size();
        Car newCar = new Car();
        carService.saveCar(car);
        assertEquals(oldSize + 1 , carService.findAllCars().size()); // tak nie powinno byc4
        carService.deleteCarById(oldSize + 1);
        assertEquals(oldSize, carService.findAllCars().size()); // tak nie powinno byc4

    }
}
