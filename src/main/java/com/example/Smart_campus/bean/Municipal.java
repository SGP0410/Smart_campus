package com.example.Smart_campus.bean;

/**
 * @author 关鑫
 * @date 2021/6/7 16:42 星期一
 */

public class Municipal {

    private String id;
    private String municipalName;
    private String provinceId;
    private String enrollStudentNum;
    private String overseasStudentNum;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMunicipalName() {
        return municipalName;
    }

    public void setMunicipalName(String municipalName) {
        this.municipalName = municipalName;
    }

    public String getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(String provinceId) {
        this.provinceId = provinceId;
    }

    public String getEnrollStudentNum() {
        return enrollStudentNum;
    }

    public void setEnrollStudentNum(String enrollStudentNum) {
        this.enrollStudentNum = enrollStudentNum;
    }

    public String getOverseasStudentNum() {
        return overseasStudentNum;
    }

    public void setOverseasStudentNum(String overseasStudentNum) {
        this.overseasStudentNum = overseasStudentNum;
    }
}
