package com.cms.dao;

import com.cms.domain.StockRecord;
import com.cms.util.MyMapper;

import java.util.List;

public interface StockRecordMapper extends MyMapper<StockRecord> {

    List<StockRecord> queryList(StockRecord param);
}