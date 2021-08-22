package com.example.Smart_campus.dao;

import com.example.Smart_campus.bean.Bulletin;

import java.util.List;

/**
 * @author 关鑫
 * @date 2021/8/19 16:38 星期四
 * @Description com.example.Smart_campus.dao
 */
public interface BulletinDao {

    public int addBulletin(Bulletin bulletin);

    public List<Bulletin> queryBulletin();

}
