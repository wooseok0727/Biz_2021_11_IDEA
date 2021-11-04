package com.wooseok.student.controller;

import com.wooseok.student.models.StudentVO;
import com.wooseok.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import java.util.List;

@Controller
public class StudentController {

    /*
     * @Autowired
     * Field Injection 방식은
     * 메모리 누수가 발생한다고 보고 되었고
     * 생성자 방식에 비해서 Null Point Exception 이 발생할 확률도 있다
     *
     * @Autowired
     * private StudentService stService;
     */

    /**
     * 생성자 주입방식
     * 1. 주입받을 객체를 선언(가급적 인터페이스로)
     * 2. final 선언하여 불변 객체로 변환
     * 3. 생성자 method 를 선언
     */
    private final StudentService stService;

    /*
        @Autowired 를 통한 자동 의존관계 주입시 여러개의 빈을 찾는다면?
        오류가 발생!
        스프링은 찾은 여러개의 빈(Bean)들 중 어떤 것을 할 기준이 없기 때문
        여러개의 빈을 찾을 때 해결할 수 있는 3가지 방법
        1) @Autowired 필드 명 매칭
        2) @Qualifier
        3) @Primary

        @Primary 와 @Qualifier 를 적절히 사용하는 것이 가장 이상적
        @Primary 는 하나의 구현체만을 사용하게 하는 것
        @Qualifier 는 @Primary 보다 귀찮지만, 디테일하게 접근하고 사용할 수 있음
        --> @Primary 보다 우선순위가 높다

        예시: 코드에서 자주 사용하는 메인 데이터베이스 커넥션을 사용하는 빈이 있고,
              코드에서 특별한 기능으로 가끔 사용하는 서브 데이터베이스의 커넥션이 있을 때
              메인 데이터베이스 커넥션을 사용하는 빈
              --> @Primary 로 기본설정

              서브 데이터에비스의 커넥션을 사용하는 빈
              --> @Qualifier 지정해서 명시적으로 획득
     */
    @Autowired
    public StudentController(@Qualifier("stServiceV1") StudentService stService) {
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
