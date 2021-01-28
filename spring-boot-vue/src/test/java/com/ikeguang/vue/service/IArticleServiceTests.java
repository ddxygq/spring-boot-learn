package com.ikeguang.vue.service;

import com.ikeguang.vue.model.Article;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

/**
 * @Author: keguang
 * @Date: 2021/1/27 18:38
 * @version: v1.0.0
 * @description:
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class IArticleServiceTests {

    @Autowired
    IArticleService iArticleService;

    @Test
    public void saveArticleTest(){
        Article article = new Article(1L, "test", "test", "test", new Date());
        iArticleService.saveArticle(article);
    }

    @Test
    public void lisTest(){
        List<Article> list = iArticleService.list();
        System.out.println(list);
    }

    @Test
    public void findByTitleTest(){
        Article article = iArticleService.findByTitle("test");
        System.out.println(article);
    }
}
