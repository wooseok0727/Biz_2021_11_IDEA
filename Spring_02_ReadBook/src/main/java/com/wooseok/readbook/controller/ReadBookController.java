package com.wooseok.readbook.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ReadBookController {

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String home() {
        return "HOME";
    }

    @RequestMapping(value = "/write",method = RequestMethod.GET)
    public String write() {
        return "RB/rb_write";
    }
}
