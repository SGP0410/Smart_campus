package com.example.Smart_campus.dao;

import com.example.Smart_campus.bean.TradingSite;

public interface TradingSiteDao {

    /**
     * 更具消费地点id查询消费地点
     * @param tradingSiteId
     * @return
     */
    public TradingSite queryTradingSiteById(String tradingSiteId);

    /**
     *
     * @param site
     * @return
     */
    public TradingSite queryTradingSiteBySite(String site);

    /**
     * 添加消费地点
     * @param tradingSite
     * @return
     */
    public int addTradingSite(TradingSite tradingSite);

}
