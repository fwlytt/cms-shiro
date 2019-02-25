package com.cms.service;

import com.cms.domain.Exp;

import java.util.List;

public interface ExpService extends IService<Exp> {

    List<Exp> queryList();
}