package com.example.myapplication;

import java.util.UUID;

public class User {
    private String userName;
    private String userLastName;
    private UUID uuid;

    public User(String userName, String userLastName, UUID uuid) {
        this.userName = userName;
        this.userLastName = userLastName;
        this.uuid = UUID.randomUUID();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public UUID getUuid() {
        return uuid;
    }


}
