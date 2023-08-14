package ParkingLot.Models;

import ParkingLot.Enums.UserType;

public class User {
    private String name;
    private String email;
    private UserType userType;
    public User(String email, String name, UserType user) {
        this.email = email;
        this.name = name;
        this.userType = user;
    }
}
