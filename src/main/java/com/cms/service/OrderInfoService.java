package com.cms.service;

import com.cms.domain.OrderInfo;
import com.cms.domain.val.OrderInfoVal;

import java.util.List;
import java.util.Map;

public interface OrderInfoService extends IService<OrderInfo> {

    List<OrderInfoVal> queryList(Map<String, String> param);

    int update(OrderInfo param);

    List<OrderInfoVal> queryBillList(Map<String, String> param);
}
