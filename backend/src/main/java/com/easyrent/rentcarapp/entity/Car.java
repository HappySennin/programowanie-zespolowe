package com.easyrent.rentcarapp.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String brandName;
    private String modelName;
    private String typeName;
    private String power;
    private BigDecimal price;

    @Override
    public String toString() {
        return "brandName=" + brandName + ", modelName=" + modelName + ", typeName=" + typeName + ", power=" + power +", price=$" + price;
    }
}
