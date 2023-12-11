package com.ojiraphers.thymelef.controller;


import com.ojiraphers.thymelef.controller.moder.dto.Member;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("lecture")

public class LectureController {

    public ModelAndView expressiond(ModelAndView mv) {
        mv.addObject("member",new Member("홍길동",20,'남',"서울시 서초구"));
        mv.addObject("hello", "hello!<h3>Thymeleaf</h3>");
        mv.setViewName("/lecture/expression");
        return mv;
    }
}

