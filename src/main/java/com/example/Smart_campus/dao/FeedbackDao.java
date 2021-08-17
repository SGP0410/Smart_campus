package com.example.Smart_campus.dao;

import com.example.Smart_campus.bean.Feedback;

import java.util.List;

/**
 * @author 关鑫
 * @date 2021/8/9 10:01 星期一
 */
public interface FeedbackDao {

    public int addFeedback(Feedback feedback);

    public List<Feedback> queryFeedback();

}
