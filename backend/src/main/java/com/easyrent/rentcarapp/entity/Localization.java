package com.easyrent.rentcarapp.entity;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Embeddable;

import static java.lang.Math.*;

@Embeddable
@Access(AccessType.PROPERTY)
public class Localization {
    private Double latitude;
    private Double longitude;

    public Localization() {
        this.latitude = 0.0;
        this.longitude = 0.0;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getDistanceFromPoint(Double latitude, Double longitude){
        return sqrt(pow(this.latitude - latitude, 2) + pow(this.longitude - longitude, 2));
    }

    @Override
    public String toString() {
        return String.valueOf(this.latitude) + " , " + String.valueOf(this.longitude);
    }
}
