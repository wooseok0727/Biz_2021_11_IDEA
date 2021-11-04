package com.wooseok.student.controller;

import com.wooseok.student.models.StudentVO;
import com.wooseok.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class StudentController {

    private final StudentService stService;

    @Autowired
    public StudentController(StudentService stService) {
        this.stService = stService;
    }

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String home() {
        return "home";
    }

    @ResponseBody
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public List<StudentVO> list(Model model) {

        List<StudentVO> stList = stService.selectAll();
        model.addAttribute("STLIST",stList);

        // return "student/list";
        return stList;
    }
}
