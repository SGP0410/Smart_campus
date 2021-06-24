package com.example.Smart_campus.dao.impl;

import com.example.Smart_campus.bean.TradingSite;
import com.example.Smart_campus.dao.TradingSiteDao;

public class TradingSiteDaoImpl extends BaseDao implements TradingSiteDao {

    @Override
    public TradingSite queryTradingSiteById(String tradingSiteId) {
        String sql = "select * from trading_site where id = ?";
        return queryForOne(TradingSite.class , sql , tradingSiteId);
    }

    @Override
    public TradingSite queryTradingSiteBySite(String site) {
        String sql = "select * from trading_site where site = ?";
        return queryForOne(TradingSite.class , sql , site);
    }

    @Override
    public int addTradingSite(TradingSite tradingSite) {
        String sql = "insert into trading_site values(?)";
        return update(sql , tradingSite.getSite());
    }
}
