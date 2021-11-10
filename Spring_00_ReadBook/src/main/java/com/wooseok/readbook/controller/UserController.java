package com.wooseok.readbook.controller;

import com.wooseok.readbook.models.UserDTO;
import com.wooseok.readbook.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/member")
public class UserController {

    private final UserService uService;

    @Autowired
    public UserController(UserService uService) {
        this.uService = uService;
    }

    @RequestMapping(value = {"/login"},method = RequestMethod.GET)
    public String login() {
        return "member/login";
    }

    @RequestMapping(value = {"/join"},method = RequestMethod.GET)
    public String join() {
        return "member/join";
    }

    @RequestMapping(value = "/join",method = RequestMethod.POST)
    public String join(UserDTO userDTO) {

        uService.insert(userDTO);

        return "redirect:/member/login";
    }


}
