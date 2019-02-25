package com.cms.service;

import com.cms.domain.Customer;

import java.util.List;

public interface CustomerService extends IService<Customer> {

    List<Customer> queryList(String key);

    int checkName(Customer param);

}
