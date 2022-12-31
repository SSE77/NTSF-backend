package com.cops.ntsf.service;

import com.cops.ntsf.constants.UserType;
import com.cops.ntsf.model.*;

public class UserService {
    public User getUserSignedUp(UserType userType,
                                String name,
                                String address,
                                String nic,
                                String email,
                                String mobileNo,
                                String password,
                                String loginId) {
        User user = new User(name, address, nic, email, mobileNo, userType);
        user.setUserInfo();

        String userId = user.getUserId();

        if (userId != null) {
            Auth auth = new Auth(userId, password);
            auth.setAuthInfo();
            switch (userType) {
                case DRIVER:
                    Driver driver = new Driver(userId, loginId);
                    driver.setDriverInfo();
                    return user;
                case PEDESTRIAN:
                    Pedestrian pedestrian = new Pedestrian(userId, loginId);
                    pedestrian.setPedestrianInfo();
                    return pedestrian;
                case VEHICLE:
                    Vehicle vehicle = new Vehicle(userId, loginId);
                    vehicle.setVehicleInfo();
                    return user;
                default:
                    throw new RuntimeException();
            }
        }
        return user;
    }

    public User getUserInfo(String userId,
                            UserType userType) {
        User user = new User(userId, userType);
        user.getUserInfo();

        userId = user.getUserId();

        if (userId != null) {
            switch (userType) {
                case DRIVER:
                    Driver driver = new Driver(userId, userType);
                    driver.getDriverInfo();
                    return user;
                default:
                    throw new RuntimeException();
            }
        }
        return user;
    }

    public User updateUserInfo(String userId,
                               String mobileNo,
                               String email,
                               String name,
                               String address) {
        User user = new User(userId, mobileNo, email, name, address);
        user.updateUserInfo();

        return user;
    }
}
