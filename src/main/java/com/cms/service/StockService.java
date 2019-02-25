package com.cms.service;

import com.cms.domain.Stock;

import java.util.List;

public interface StockService extends IService<Stock> {

    List<Stock> queryList(String key);

    int checkName(Stock param);

    void produceStock();
}
