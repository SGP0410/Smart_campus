package com.example.Smart_campus.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 关鑫
 * @date 2021/8/9 16:17 星期一
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClassSchedule {

    /**
     * id
     * classid
     * teacher
     * course
     * number
     */

    private String id;
    private String classid;
    private String teacher;
    private String course;
    private String number;
    private String name;


}
