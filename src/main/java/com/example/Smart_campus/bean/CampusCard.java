package com.example.Smart_campus.bean;

public class CampusCard {
    private String id;
    private String schoolCardId;
    private int balance;
    private String openDate;
    private int expenditure;

    public int getExpenditure() {
        return expenditure;
    }

    public void setExpenditure(int expenditure) {
        this.expenditure = expenditure;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSchoolCardId() {
        return schoolCardId;
    }

    public void setSchoolCardId(String schoolCardId) {
        this.schoolCardId = schoolCardId;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getOpenDate() {
        return openDate;
    }

    public void setOpenDate(String openDate) {
        this.openDate = openDate;
    }
}
