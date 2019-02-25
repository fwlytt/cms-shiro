package com.cms.dao;

import com.cms.domain.base.SelectVal;

import java.util.List;

public interface CommonMapper {

    List<SelectVal> getStockList();

    List<SelectVal> getCustomerList();

    List<SelectVal> getWorkshopList();

    List<SelectVal> getWorkshopListByCustomerId(Integer id);

}