package com.example.Smart_campus.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 关鑫
 * @date 2021/8/2 15:13 星期一
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
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
    private String idCard;
    private String address;
    private String dateOfBirth;
    private String nationality;
    private String age;
    private String face;

}
