package com.example.Smart_campus.bean;

/**
 * @author 关鑫
 * @date 2021/6/7 15:12 星期一
 */

public class College {

    /**
     * id
     * collegeName
     * collegeId
     */

    private String id;
    private String collegeId;
    private String collegeName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCollegeId() {
        return collegeId;
    }

    public void setCollegeId(String collegeId) {
        this.collegeId = collegeId;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }
}
