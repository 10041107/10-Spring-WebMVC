package com.ojiraphers.intercaptor;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/*")
public class InterceptorTestController extends Throwable {

     @PostMapping("stopwatch")
    public Object StringhandlerMethod() throws  InterceptorTestController{
         System.out.println("핸들러 메소드 호출함");
         try {
             Thread.sleep(1000); // 대기 1초
         } catch (InterruptedException e) {
             throw new RuntimeException(e);
         }

         return "result";
     }




}
