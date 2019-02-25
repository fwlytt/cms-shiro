package com.cms.dao;

import com.cms.domain.OrderInfo;
import com.cms.domain.val.OrderInfoVal;
import com.cms.util.MyMapper;

import java.util.List;
import java.util.Map;

public interface OrderInfoMapper extends MyMapper<OrderInfo> {

    List<OrderInfoVal> queryList(Map<String, String> param);

    int update(OrderInfo param);

    List<OrderInfoVal> queryBillList(Map<String, String> param);
}