package com.wooseok.security.controller;

import com.wooseok.security.models.User;
import com.wooseok.security.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
@RequestMapping(value = "/member")
public class MemberController {

    private final MemberService memberService;

    public MemberController(@Qualifier("memberServiceV1") MemberService memberService) {
        this.memberService = memberService;
    }

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

        memberService.insert(user);
        return "/member/register";
    }

    @ResponseBody
    @RequestMapping(value = "/idcheck",method = RequestMethod.GET)
    public UserDetails idcheck(String username) {

        /**
         * service(dao) findById(username) 으로 조회를 하여
         * 결과를 바로 return 할 수 있다
         * 
         * 이미 데이터가 있으면 회원정보가 return
         * 그렇지 않으면 null 값이 자동으로 return 될 것이다
         *
         * return sService.findById(username)
         */

//        if(username.equalsIgnoreCase("wooseok")) {
//            return "FAIL";
//        } else {
//            return null;
//        }
        return memberService.findById(username);
    }


}
