package com.cms.service;

import com.cms.domain.Article;
import com.cms.domain.CmsWorks;

import java.util.List;

public interface ArticleService extends IService<Article> {

    List<Article> queryList(String key);

    List<Article> queryFullList();

    List<Article> queryHomeShowList();
}