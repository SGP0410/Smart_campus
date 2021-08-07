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
        String sql = "insert into approve(schoolCard,title,grade,idCard,time,state,clas,msg) values(?,?,?,?,?,?,?,?)";
        return update(sql,
                approve.getSchoolCard(),
                approve.getTitle(),
                approve.getGrade(),
                approve.getIdCard(),
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
}
