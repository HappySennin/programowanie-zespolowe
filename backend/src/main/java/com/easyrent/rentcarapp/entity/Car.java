package com.easyrent.rentcarapp.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.swing.text.Position;
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
    private String typeName;
    private String power;
    private BigDecimal price;
    @Embedded
    private Localization localization = new Localization();
    private String url;

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

    public String getUrl()
    {
        return url;
    }

    public void setUrl(String url)
    {
        this.url = url;
    }

    public Localization getLocalization() {
        return localization;
    }

    public void setLocalization(Localization localization) {
        this.localization = localization;
    }

    public Car(String brand, String model, String type, String power, BigDecimal price) {
        this.brandName = brand;
        this.modelName = model;
        this.typeName = type;
        this.power = power;
        this.price = price;
    }
    @Override
    public String toString() {
        return "brandName=" + brandName + ", modelName=" + modelName + ", typeName=" + typeName +
                ", power=" + power +", price=$" + price +", localization=" + localization.toString() +", url=" + url;
    }
}
