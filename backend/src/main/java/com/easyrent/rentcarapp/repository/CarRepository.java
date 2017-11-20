package com.easyrent.rentcarapp.repository;

import com.easyrent.rentcarapp.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
    Car findById(Long id);
    List<Car> findByBrandName(String brand);
    List<Car> findByModelName(String model);
    List<Car> findByTypeName(String name);
    List<Car> findByPower(String power);
    List<Car> findByPrice(BigDecimal price);
}
