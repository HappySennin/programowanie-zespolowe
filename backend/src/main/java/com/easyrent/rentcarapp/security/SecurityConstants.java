package com.easyrent.rentcarapp.security;

public class SecurityConstants {
    public static final String SECRET = "SecretKey";
    public static final long EXPIRATION_TIME = 1800000; // 1800000ms = 30 min
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final String SIGN_UP_URL = "/users/sign-up";
    public static final String CARS_URL = "/cars/**";
    public static final String CARS_LOCATION = "/cars/location";
    public static final String RESERVATION_URL = "/reservations/car/{car_id}/start/{start}/end/{end}";
}