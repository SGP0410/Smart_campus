package com.example.Smart_campus.dao;

import com.example.Smart_campus.bean.TradingSite;

public interface TradingSiteDao {

    public TradingSite queryTradingSiteById(String tradingSiteId);

    public TradingSite queryTradingSiteBySite(String site);

    public int addTradingSite(TradingSite tradingSite);

}
