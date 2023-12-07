package com.ojiraphers.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;

@ControllerAdvice  // 이 클래스가 모든 컨트롤러에 대해 예외를 처리하는 클래스임을 명시
public class GlobalExceptionHandler {

    @ExceptionHandler(NullPointerException.class)  // NullPointerException이 발생하면 이 메소드가 처리
    public String nullPointerExcaptionHandler(NullPointerException e){
        System.out.println("global레벨의 eXception처리");
        return "error/nullPointer";  // 에러 페이지로 리다이렉트
    }


    @ExceptionHandler(MemberRegistExcaption.class)  // MemberRegistExcaption 예외가 발생하면 이 메소드가 처리
    public String userExceptionHandler(Model model, MemberRegistExcaption exception){
        System.out.println("global레벨의 excaption처리");
        model.addAttribute("exception", exception);  // 예외 정보를 모델에 담아 에러 페이지에 전달
        return "error/memberRegist";  // 에러 페이지로 리다이렉트
    }

    @ExceptionHandler(Exception.class)  // 위에서 명시하지 않은 모든 예외를 처리
    public String nullPointExcaptionHandler(Exception e){
        System.out.println("excaption 발생함");
        return "error/default";  // 기본 에러 페이지로 리다이렉트
    }


    @GetMapping("controller-user")  // "/controller-user" URL에 대한 GET 요청을 처리
    public String userException() throws MemberRegistExcaption{
        boolean check = true;
        if(check){
            throw new MemberRegistExcaption("입사가 불가능합니다.");  // 예외를 일부러 발생시킴
        }
        return null;
    }

}
