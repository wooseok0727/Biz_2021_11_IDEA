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

    /**
     * @Autowired
     * Field Injection 방식은
     * 메모리 누수가 발생한다고 보고 되었고
     * 생성자 방식에 비해서 Null Point Exception 이 발생할 확률도 있다
     */
//    @Autowired
//    private StudentService stService;

    /**
     * 생성자 주입방식
     * 1. 주입받을 객체를 선언(가급적 인터페이스로)
     * 2. final 선언하여 불변 객체로 변환
     * 3. 생성자 method 를 선언
     */
    private final StudentService stService;

    @Autowired
    public StudentController(StudentService stService) {
        this.stService = stService;
    }

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String home() {
        return "home";
    }

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public String list(Model model) {

        List<StudentVO> stList = stService.selectAll();
        model.addAttribute("STLIST",stList);

        return "student/list";
    }
}
