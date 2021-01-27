package com.ikeguang.vue.service.impl;

import com.ikeguang.vue.model.Article;
import com.ikeguang.vue.repository.ArticleRepository;
import com.ikeguang.vue.service.IArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: keguang
 * @Date: 2021/1/27 18:37
 * @version: v1.0.0
 * @description:
 */
@Service
public class ArticleServiceImpl implements IArticleService {
    @Autowired
    ArticleRepository articleRepository;

    @Override
    public void saveArticle(Article article) {
        articleRepository.saveArticle(article);
    }
}
