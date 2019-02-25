package com.cms.dao;

import com.cms.domain.Article;
import com.cms.domain.val.WorkshopVal;
import com.cms.util.MyMapper;

import java.util.List;

public interface ArticleMapper extends MyMapper<Article> {

    List<Article> queryList(String key);

    List<Article> queryFullList();

    List<Article> queryHomeShowList();
}