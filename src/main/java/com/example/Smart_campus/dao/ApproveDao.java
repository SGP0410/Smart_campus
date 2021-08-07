package com.example.Smart_campus.dao;

import com.example.Smart_campus.bean.Approve;

import java.util.List;

/**
 * @author 关鑫
 * @date 2021/8/7 9:47 星期六
 */
public interface ApproveDao {

    public int updateApproveDao(Approve Approve);

    public List<Approve> queryApprove();

}
