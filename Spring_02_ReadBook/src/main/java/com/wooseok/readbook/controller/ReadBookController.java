package com.wooseok.readbook.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ReadBookController {

    Logger logger = LoggerFactory.getLogger(ReadBookController.class);

    @Value("${db.username}")
    private String userName;

    @Value("${db.password}")
    private String password;

    @Value("${db.driver}")
    private String className;

    @Value("${db.url}")
    private String url;


    @ResponseBody
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home() {

        logger.debug("여기는 홈 입니다");
        // return "HOME";

        return String.format("username %s <br> " +
                "password %s <br>" +
                "url %s <br>" +
                "driver %s <br>",userName, password, url, className);
    }

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public String list() {
        return "RB/rb_list";
    }

    @RequestMapping(value = "/write",method = RequestMethod.GET)
    public String write() {
        return "RB/rb_write";
    }
}
