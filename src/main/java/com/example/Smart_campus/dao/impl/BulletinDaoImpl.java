package com.example.Smart_campus.dao.impl;

import com.example.Smart_campus.bean.Bulletin;
import com.example.Smart_campus.dao.BulletinDao;

import java.util.List;

/**
 * @author 关鑫
 * @date 2021/8/19 16:45 星期四
 * @Description com.example.Smart_campus.dao.impl
 */
public class BulletinDaoImpl extends BaseDao implements BulletinDao {
    @Override
    public int addBulletin(Bulletin bulletin) {
        String sql = "insert into bulletin values(?,?,?,?)";
        return update(sql,
                bulletin.getTitle(),
                bulletin.getMsg(),
                bulletin.getTime(),
                bulletin.getFaculty()
                );
    }

    @Override
    public List<Bulletin> queryBulletin() {
        String sql = "select * from bulletin";
        return queryForList(Bulletin.class,sql);
    }
}
