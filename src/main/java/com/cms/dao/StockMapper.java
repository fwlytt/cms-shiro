package com.cms.dao;

import com.cms.domain.Stock;
import com.cms.util.MyMapper;

import java.util.List;

public interface StockMapper extends MyMapper<Stock> {

    List<Stock> queryList(String key);

    int checkName(Stock param);

    List<Stock> queryProduce();

    int updateNowDay();

}