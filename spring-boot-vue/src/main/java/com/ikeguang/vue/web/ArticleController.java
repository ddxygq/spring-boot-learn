package com.ikeguang.vue.web;

import com.ikeguang.vue.model.Article;
import com.ikeguang.vue.result.Result;
import com.ikeguang.vue.service.IArticleService;
import com.ikeguang.vue.utils.ResultConfigFactory;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: keguang
 * @Date: 2021/1/28 9:50
 * @version: v1.0.0
 * @description:
 */
@RestController
@RequestMapping("/api/article")
@Api(tags = "文章管理")
public class ArticleController {

    @Autowired
    IArticleService iArticleService;

    @ApiOperation("保存文章")
    @PostMapping("/addArticle")
    public Result addArticle(@RequestBody  Article article){
        System.out.println(article);
        iArticleService.saveArticle(article);

        return ResultConfigFactory.builtResult(null);
    }

}
