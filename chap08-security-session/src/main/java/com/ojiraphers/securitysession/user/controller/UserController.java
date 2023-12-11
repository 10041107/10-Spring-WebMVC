package com.ojiraphers.securitysession.user.controller;

import com.ojiraphers.securitysession.user.dao.UserMapper;
import com.ojiraphers.securitysession.user.model.dto.SignupDTO;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
public class UserController {

    private UserMapper memberService;

    @GetMapping("/signup")
    public void signup(){

    }

    @PostMapping("/signup")
    public ModelAndView signup(@ModelAttribute SignupDTO signupDTO, ModelAndView mv){
        //유효성 검사 로직 추가

        int result = memberService.regist(signupDTO);

        String message;
        if(result>0){
            message = "회원 가입이 완료되었습니다.";
            mv.setViewName("auth/login");

        }else {
            message="회원가입에 실패했습니다";
            mv.setViewName("user/signup");
        }
        mv.addObject("message",message);

        return mv;
    }

}
