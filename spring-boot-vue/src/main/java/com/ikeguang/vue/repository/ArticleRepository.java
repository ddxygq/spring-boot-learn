package com.ikeguang.vue.repository;

import com.ikeguang.vue.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: keguang
 * @Date: 2021/1/27 18:34
 * @version: v1.0.0
 * @description:
 */
public interface ArticleRepository extends JpaRepository<Article, Long> {

    Article findByTitle(String title);
}
