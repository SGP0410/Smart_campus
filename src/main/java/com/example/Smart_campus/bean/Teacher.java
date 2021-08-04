package com.example.Smart_campus.bean;

/**
 * @author 关鑫
 * @date 2021/8/2 15:13 星期一
 */
public class Teacher {

    /**
     * id
     * name
     * sex
     * schoolCard
     * collegeId
     * password
     * status
     */

    private String id;
    private String name;
    private String sex;
    private String schoolCard;
    private String collegeId;
    private String password;
    private String status;

    public Teacher() {
    }

    public Teacher(String id, String name, String sex, String schoolCard, String collegeId, String password, String status) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.schoolCard = schoolCard;
        this.collegeId = collegeId;
        this.password = password;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getSchoolCard() {
        return schoolCard;
    }

    public void setSchoolCard(String schoolCard) {
        this.schoolCard = schoolCard;
    }

    public String getCollegeId() {
        return collegeId;
    }

    public void setCollegeId(String collegeId) {
        this.collegeId = collegeId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", schoolCard='" + schoolCard + '\'' +
                ", collegeId='" + collegeId + '\'' +
                ", password='" + password + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
