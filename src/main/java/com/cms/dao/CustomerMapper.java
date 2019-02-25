package com.cms.dao;

import com.cms.domain.Customer;
import com.cms.util.MyMapper;

import java.util.List;

public interface CustomerMapper extends MyMapper<Customer> {

    List<Customer> queryList(String key);

    int checkName(Customer param);
}