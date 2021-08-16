package com.example.Smart_campus.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 关鑫
 * @date 2021/8/12 15:26 星期四
 * @Description com.example.Smart_campus.bean
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Certificate {

    /**
     * id
     * title
     * level
     * time
     * member
     * grade
     * teacher
     * years
     * name
     * schoolcard
     */

    private String id;
    private String title;
    private String level;
    private String time;
    private String member;
    private String grade;
    private String teacher;
    private String years;
    private String name;
    private String schoolcard;
    private String state;
    private String classid;

}
