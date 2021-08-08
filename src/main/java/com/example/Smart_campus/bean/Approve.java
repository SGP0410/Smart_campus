package com.example.Smart_campus.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 关鑫
 * @date 2021/8/7 9:46 星期六
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Approve {

    private String id;
    private String schoolCard;
    private String title;
    private String grade;
    private String majorId;
    private String time;
    private String state;
    private String clas;
    private String msg;

}
