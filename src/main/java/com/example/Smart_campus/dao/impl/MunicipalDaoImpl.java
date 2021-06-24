package com.example.Smart_campus.dao.impl;

import com.example.Smart_campus.bean.Municipal;
import com.example.Smart_campus.dao.MunicipalDao;

import java.util.List;

/**
 * @author 关鑫
 * @date 2021/6/7 16:43 星期一
 */

public class MunicipalDaoImpl extends BaseDao implements MunicipalDao {

    /**
     *  通过省级id查询市
     * @param provinceId 省级id
     * @return
     */
    @Override
    public List<Municipal> queryMunicipalByProvinceId(String provinceId) {
        String sql = "select * from municipal where provinceId = ?";
        return queryForList(Municipal.class,sql,provinceId);
    }

    @Override
    public List<Municipal> queryMunicipalAll() {
        String sql = "select * from municipal";
        return queryForList(Municipal.class,sql);
    }

    @Override
    public Municipal queryMunicipalByName(String municipalName) {
        String sql = "select * from municipal where municipalName = ?";
        return queryForOne(Municipal.class , sql , municipalName);
    }
}
