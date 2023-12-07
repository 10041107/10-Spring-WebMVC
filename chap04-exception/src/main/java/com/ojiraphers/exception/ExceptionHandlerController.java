package com.ojiraphers.exception;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ExceptionHandlerController {

    @GetMapping("controller-null")
    public String nullPointerExceptionTest(){
        String str = null;

        System.out.println(str.charAt(0));

        return "/main";
    }

    @ExceptionHandler(NullPointerException.class)
    public String nullPointerExcaptionHandler(NullPointerException e){
        System.out.println("controller레벨의 excaption처리");
        return "error/nullPointer";
    }


}
