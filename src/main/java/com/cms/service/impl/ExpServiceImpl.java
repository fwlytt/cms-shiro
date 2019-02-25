package com.cms.service.impl;

import com.cms.dao.ExpMapper;
import com.cms.domain.Exp;
import com.cms.service.ExpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpServiceImpl extends BaseService<Exp> implements ExpService {

    @Autowired
    private ExpMapper expMapper;

    @Override
    public List<Exp> queryList() {
        return expMapper.queryList();
    }
}
