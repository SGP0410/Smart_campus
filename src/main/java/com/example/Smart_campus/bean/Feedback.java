package com.example.Smart_campus.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 关鑫
 * @date 2021/8/9 10:00 星期一
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Feedback {

    /**
     * id
     * title
     * msg
     * time
     * state
     */

    private String id;
    private String title;
    private String msg;
    private String time;
    private String state;


}
