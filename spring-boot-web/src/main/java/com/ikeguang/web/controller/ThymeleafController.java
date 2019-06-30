package com.ikeguang.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * @ Author: keguang
 * @ Date: 2019/6/27 20:24
 * @ version: v1.0.0
 * @ description:
 */
@Controller
public class ThymeleafController {

    @RequestMapping("/hi")
    public String hello(Locale locale, Model model){
        model.addAttribute("greeting", "Hello");
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
        String formettedDate = dateFormat.format(date);
        model.addAttribute("currentTime", formettedDate);

        return "hello";
    }
}
