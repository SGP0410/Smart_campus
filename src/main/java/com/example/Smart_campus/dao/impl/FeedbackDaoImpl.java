package com.example.Smart_campus.dao.impl;

import com.example.Smart_campus.bean.Feedback;
import com.example.Smart_campus.dao.FeedbackDao;

import java.util.List;

/**
 * @author 关鑫
 * @date 2021/8/9 10:02 星期一
 */
public class FeedbackDaoImpl extends BaseDao implements FeedbackDao {

    @Override
    public int addFeedback(Feedback feedback) {
        String sql = "insert into feedback(title,msg,time,state) values(?,?,?,?)";
        return update(sql,
                feedback.getTitle(),
                feedback.getMsg(),
                feedback.getTime(),
                feedback.getState()
        );
    }

    @Override
    public List<Feedback> queryFeedback() {
        String sql = "select * from feedback";
        return queryForList(Feedback.class,sql);
    }
}
