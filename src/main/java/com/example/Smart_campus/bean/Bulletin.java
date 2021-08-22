package com.example.Smart_campus.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 关鑫
 * @date 2021/8/19 16:29 星期四
 * @Description com.example.Smart_campus.bean
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bulletin {

    private String id;
    private String title;
    private String msg;
    private String time;
    private String faculty;

}
