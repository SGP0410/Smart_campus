package com.example.Smart_campus.bean;

public class TradingRecord {
    private String id;
    private String schoolCardId;
    private String tradingDate;
    private String tradingType;
    private String tradingSiteId;
    private String tradingAmount;
    private String tradingDescription;

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

    public String getTradingDate() {
        return tradingDate;
    }

    public void setTradingDate(String tradingDate) {
        this.tradingDate = tradingDate;
    }

    public String getTradingType() {
        return tradingType;
    }

    public void setTradingType(String tradingType) {
        this.tradingType = tradingType;
    }

    public String getTradingSiteId() {
        return tradingSiteId;
    }

    public void setTradingSiteId(String tradingSiteId) {
        this.tradingSiteId = tradingSiteId;
    }

    public String getTradingAmount() {
        return tradingAmount;
    }

    public void setTradingAmount(String tradingAmount) {
        this.tradingAmount = tradingAmount;
    }

    public String getTradingDescription() {
        return tradingDescription;
    }

    public void setTradingDescription(String tradingDescription) {
        this.tradingDescription = tradingDescription;
    }
}
