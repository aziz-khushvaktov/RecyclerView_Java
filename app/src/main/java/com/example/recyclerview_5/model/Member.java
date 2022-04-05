package com.example.recyclerview_5.model;

import java.util.List;

public class Member {


    private String firstName;
    private String lastName;
    private boolean available = false;
    private List<MemberSub> memberSubs;

    public Member(){}

    public Member(String firstName, String lastName, boolean available) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.available = available;
    }
    public Member(String firstName, String lastName, boolean available, List<MemberSub> memberSubs) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.available = available;
        this.memberSubs = memberSubs;
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

    public List<MemberSub> getMemberSubs() {
        return memberSubs;
    }

    public void setMemberSubs(List<MemberSub> memberSubs) {
        this.memberSubs = memberSubs;
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
