package com.example.Smart_campus.bean;

/**
 * @author 关鑫
 * @date 2021/6/7 16:00 星期一
 */

public class Major {

    /**
     * id
     * majorName
     * collegeId
     */

    private String id;
    private String majorName;
    private String collegeId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMajorName() {
        return majorName;
    }

    public void setMajorName(String majorName) {
        this.majorName = majorName;
    }

    public String getCollegeId() {
        return collegeId;
    }

    public void setCollegeId(String collegeId) {
        this.collegeId = collegeId;
    }

}
