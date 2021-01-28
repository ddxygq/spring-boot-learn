package com.ikeguang.vue.service;

import com.ikeguang.vue.model.Article;

import java.util.List;

/**
 * @Author: keguang
 * @Date: 2021/1/27 18:36
 * @version: v1.0.0
 * @description:
 */
public interface IArticleService {

    void saveArticle(Article article);

    List<Article> list();

    Article findByTitle(String title);
}
