package com.ikeguang.oath.controller;

import com.ikeguang.oath.model.GitHubAccessModel;
import com.ikeguang.oath.util.GitHubProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/oauth")
@Slf4j
public class IndexController {

    // @Autowired
    GitHubAccessModel gitHubAccessModel = new GitHubAccessModel();

    @Autowired
    private GitHubProvider gitHubProvider;

    @RequestMapping({"/", "index"})
    public String index(){
        return "index";
    }

    @GetMapping("/callback/{source}")
    @ResponseBody
    public String callback(@PathVariable(name = "source") String source,
                           @RequestParam(name="code") String code,
                           @RequestParam(name = "state") String state){
        log.info("source -> {}, code -> {}, state -> {}", source, code, state);
        gitHubAccessModel.setCode(code);
        gitHubAccessModel.setState(state);
        //进行doPost请求，获取access_token
        gitHubProvider.getAccessToken(gitHubAccessModel);
        return "finish";
    }
}
