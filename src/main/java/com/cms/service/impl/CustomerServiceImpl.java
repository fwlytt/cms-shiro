package com.cms.service.impl;

import com.cms.dao.CustomerMapper;
import com.cms.domain.Customer;
import com.cms.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl extends BaseService<Customer> implements CustomerService {

    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public List<Customer> queryList(String key) {
        return customerMapper.queryList(key);
    }

    @Override
    public int checkName(Customer param) {
        return customerMapper.checkName(param);
    }
}
