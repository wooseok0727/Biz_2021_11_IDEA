package com.wooseok.security.controller;

import com.wooseok.security.models.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Slf4j
@Controller
@RequestMapping(value = "/member")
public class MemberController {

    // login form 을 열기 위한 URL
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login() {

        return "/member/login";
    }

    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public String register() {

        return "/member/register";
    }

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String register(User user) {

        log.debug("회원가입 : {}",user.toString());
        return "/member/register";
    }


}
