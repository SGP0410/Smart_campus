package com.example.Smart_campus.dao;

import com.example.Smart_campus.bean.TradingRecord;
import java.util.List;

public interface TradingRecordDao {

    public List<TradingRecord> queryTradingRecordBySchoolCardId(String schoolCardId);

    public int addTradingRecord(TradingRecord tradingRecord);

    public int deleteTradingRecordById(String tradingRecordId);

}
