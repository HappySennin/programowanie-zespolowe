package com.easyrent.rentcarapp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String brandName;
    private String modelName;
    private String typeName;
    private String power;
    private BigDecimal price;

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public String getBrandName()
    {
        return brandName;
    }

    public void setBrandName(String brandName)
    {
        this.brandName = brandName;
    }

    public String getModelName()
    {
        return modelName;
    }

    public void setModelName(String modelName)
    {
        this.modelName = modelName;
    }

    public String getTypeName()
    {
        return typeName;
    }

    public String getMoc()
    {
        return power;
    }

    public void setMoc(String power)
    {
        this.power = power;
    }

    public void setTypeName(String typeName)
    {
        this.typeName = typeName;
    }

    public BigDecimal getPrice()
    {
        return price;
    }

    public void setPrice(BigDecimal price)
    {
        this.price = price;
    }

    @Override
    public String toString() {
        return "brandName=" + brandName + ", modelName=" + modelName + ", typeName=" + typeName + ", power=" + power +", price=$" + price;
    }

}
