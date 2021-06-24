package com.example.Smart_campus.bean;

/**
 * @author 关鑫
 * @date 2021/6/8 15:33 星期二
 */

public class Student {

    /**
     * id
     * name
     * municipalld
     * povertyStudent
     * sex
     * grade
     * expenditure
     * majorld
     * wordNatureld
     * yu
     * shu
     * wai
     * schoolCard
     */


    private String id;
    private String name;
    private String municipalId;
    private String povertyStudent;
    private String sex;
    private String grade;
    private String expenditure;
    private String majorId;
    private String wordNatureId;
    private String yu;
    private String shu;
    private String wai;
    private String schoolCard;
    private String sum;

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", municipalId='" + municipalId + '\'' +
                ", povertyStudent='" + povertyStudent + '\'' +
                ", sex='" + sex + '\'' +
                ", grade='" + grade + '\'' +
                ", expenditure='" + expenditure + '\'' +
                ", majorId='" + majorId + '\'' +
                ", wordNatureId='" + wordNatureId + '\'' +
                ", yu='" + yu + '\'' +
                ", shu='" + shu + '\'' +
                ", wai='" + wai + '\'' +
                ", schoolCard='" + schoolCard + '\'' +
                ", sum=" + sum +
                '}';
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

    public String getMunicipalId() {
        return municipalId;
    }

    public void setMunicipalId(String municipalId) {
        this.municipalId = municipalId;
    }

    public String getPovertyStudent() {
        return povertyStudent;
    }

    public void setPovertyStudent(String povertyStudent) {
        this.povertyStudent = povertyStudent;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getExpenditure() {
        return expenditure;
    }

    public void setExpenditure(String expenditure) {
        this.expenditure = expenditure;
    }

    public String getMajorId() {
        return majorId;
    }

    public void setMajorId(String majorId) {
        this.majorId = majorId;
    }

    public String getWordNatureId() {
        return wordNatureId;
    }

    public void setWordNatureId(String wordNatureId) {
        this.wordNatureId = wordNatureId;
    }

    public String getYu() {
        return yu;
    }

    public void setYu(String yu) {
        this.yu = yu;
    }

    public String getShu() {
        return shu;
    }

    public void setShu(String shu) {
        this.shu = shu;
    }

    public String getWai() {
        return wai;
    }

    public void setWai(String wai) {
        this.wai = wai;
    }

    public String getSchoolCard() {
        return schoolCard;
    }

    public void setSchoolCard(String schoolCard) {
        this.schoolCard = schoolCard;
    }

    public String getSum() {
        return sum;
    }

    public void setSum(String sum) {
        this.sum = sum;
    }
}
