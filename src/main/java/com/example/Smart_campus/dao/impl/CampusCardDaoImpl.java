package com.example.Smart_campus.dao.impl;

import com.example.Smart_campus.bean.CampusCard;
import com.example.Smart_campus.dao.CampusCardDao;
import java.util.List;

public class CampusCardDaoImpl extends BaseDao implements CampusCardDao {

    @Override
    public List<CampusCard> queryCampusCardAll() {
        String sql = "select * from campus_card";
        return queryForList(CampusCard.class, sql);
    }

    @Override
    public CampusCard queryCampusCardBySchoolCardId(String schoolCardId) {
        String sql = "select * from campus_card where schoolCardId = ?";
        return queryForOne(CampusCard.class, sql, schoolCardId);
    }

    @Override
    public int updateCampusCardForBalance(CampusCard campusCard) {
        //UPDATE 表名称 SET 列名称 = 新值 WHERE 列名称 = 某值
        String sql = "update campus_card set balance = ? where schoolCardId = ?";
        return update(sql, campusCard.getBalance(), campusCard.getSchoolCardId());
    }

    @Override
    public int updateCampusCardForExpenditure(CampusCard campusCard) {
        //UPDATE 表名称 SET 列名称 = 新值 WHERE 列名称 = 某值
        String sql = "update campus_card set balance = ? where schoolCardId = ?";
        return update(sql, campusCard.getExpenditure(), campusCard.getSchoolCardId());
    }

    @Override
    public int addCampusCard(CampusCard campusCard) {
        //INSERT INTO 表名称 VALUES (值1, 值2,....)
        String sql = "insert into campus_card values(?,?,?)";
        return update(sql, campusCard.getSchoolCardId(), campusCard.getBalance(),
            campusCard.getOpenDate());
    }

    @Override
    public int deleteCampusCardBySchoolCardId(String schoolCardId) {
        //DELETE FROM 表名称 WHERE 列名称 = 值
        String sql = "delete from campus_card where schoolCardId = ?";
        return update(sql , schoolCardId);
    }
}
