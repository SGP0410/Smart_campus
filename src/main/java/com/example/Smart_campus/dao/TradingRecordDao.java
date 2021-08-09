package com.example.Smart_campus.dao;

import com.example.Smart_campus.bean.TradingRecord;
import java.util.List;

public interface TradingRecordDao {

    /**
     * 更具校园卡查询消费记录
     * @param schoolCardId
     * @return
     */
    public List<TradingRecord> queryTradingRecordBySchoolCardId(String schoolCardId);

    /**
     * 添加消费记录
     * @param tradingRecord
     * @return
     */
    public int addTradingRecord(TradingRecord tradingRecord);

    /**
     * 更具消费记录id删除消费记录
     * @param tradingRecordId
     * @return
     */
    public int deleteTradingRecordById(String tradingRecordId);

}
