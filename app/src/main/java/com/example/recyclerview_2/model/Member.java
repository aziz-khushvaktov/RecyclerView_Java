package com.example.recyclerview_2.model;

public class Member {

    private String firstName;
    private String lastName;
    private boolean available = false;

    public Member(String firstName, String lastName, boolean available) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.available = available;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
