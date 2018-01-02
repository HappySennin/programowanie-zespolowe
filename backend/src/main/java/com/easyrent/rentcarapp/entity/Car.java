package com.easyrent.rentcarapp.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String brandName;
    private String modelName;

    public Long getId()
    {
        return id;
    }

    public String getBrandName()
    {
        return brandName;
    }

    public String getModelName()
    {
        return modelName;
    }

    public String getTypeName()
    {
        return typeName;
    }

    public String getPower()
    {
        return power;
    }

    public BigDecimal getPrice()
    {
        return price;
    }

    private String typeName;
    private String power;
    private BigDecimal price;

    public Car(String brand, String model, String type, String power, BigDecimal price) {
        this.brandName = brand;
        this.modelName = model;
        this.typeName = type;
        this.power = power;
        this.price = price;
    }
    @Override
    public String toString() {
        return "brandName=" + brandName + ", modelName=" + modelName + ", typeName=" + typeName + ", power=" + power +", price=$" + price;
    }
}
