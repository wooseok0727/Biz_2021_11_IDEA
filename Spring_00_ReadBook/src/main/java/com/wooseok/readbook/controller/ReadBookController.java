package com.wooseok.readbook.controller;

import com.wooseok.readbook.models.ReadBookDTO;
import com.wooseok.readbook.service.ReadBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class ReadBookController {

    private final ReadBookService rbService;

    @Autowired
    public ReadBookController(ReadBookService rbService) {
        this.rbService = rbService;
    }

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String home() {

        return "redirect:/list";
    }

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public String list(Model model) {

        List<ReadBookDTO> bookList = rbService.selectAll();
        model.addAttribute("BOOKS",bookList);

        return "readbook/list";
    }

    @RequestMapping(value = "/insert",method = RequestMethod.GET)
    public String insert() {
        return "readbook/write";
    }

    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    public String insert(ReadBookDTO readBookDTO) {

        rbService.readBookInsert(readBookDTO);
        return "redirect:/";
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public String update() {
        return "redirect:/";
    }

    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public String delete() {
        return "redirect:/";
    }
}
