package com.cms.dao;

import com.cms.domain.Exp;
import com.cms.util.MyMapper;

import java.util.List;

public interface ExpMapper extends MyMapper<Exp> {

    List<Exp> queryList();
}