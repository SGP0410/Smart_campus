package com.example.Smart_campus.dao.impl;

import com.example.Smart_campus.bean.Approve;
import com.example.Smart_campus.dao.ApproveDao;

import java.util.List;

/**
 * @author 关鑫
 * @date 2021/8/7 9:48 星期六
 */
public class ApproveDaoImpl extends BaseDao implements ApproveDao {

    @Override
    public int updateApproveDao(Approve approve) {
        String sql = "insert into approve(schoolCard,title,grade,majorId,time,state,clas,msg) values(?,?,?,?,?,?,?,?)";
        return update(sql,
                approve.getSchoolCard(),
                approve.getTitle(),
                approve.getGrade(),
                approve.getMajorId(),
                approve.getTime(),
                approve.getState(),
                approve.getClas(),
                approve.getMsg());
    }

    @Override
    public List<Approve> queryApprove() {
        String sql = "select * from approve";
        return queryForList(Approve.class,sql);
    }

    @Override
    public int modify(String id, String msg) {
        String sql = "update approve set msg = ? where id = ?";
        return update(sql,msg,id);
    }

    @Override
    public List<Approve> queryMajorId(String majorid) {
        String sql = "select * from approve where majorId = ?";
        return queryForList(Approve.class,sql,majorid);
    }

    @Override
    public int updateState(String state, String id) {
        String sql = "update approve set state = ? where id = ?";
        return update(sql,state,id);
    }
}
