package com.ojiraphers.request;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/*
DispatcherServlet은 웹 요청을 받는 즉시 @Controller가 달린 컨트롤러 클래스에 자리를 위임한다.
해당 컨트롤러 클래스의 핸들러 메서드에서는 다양한 @RequestMapping 어노테이션을 사용하여 요청을 처리한다.

http://localhost:8080/ - 이 주소는 웹 애플리케이션 서버에 접속하기 위한 기본 주소이다.
*/

    @Controller // 이 클래스를 Spring MVC의 컨트롤러로 등록한다.
    public class MethodMappingTestController {
        /*
        메소드 방식 미지정 - HTTP 요청 메소드(예: GET, POST)를 지정하지 않으면 모든 요청 메소드를 처리할 수 있다.
        */
        @RequestMapping("/menu/regist") // '/menu/regist' 경로로 들어오는 요청을 처리한다.
        public String registMenu(Model model) {
            // model 객체에 message라는 이름의 속성을 추가한다. 이 속성은 뷰에서 사용될 수 있다.
            model.addAttribute("message", "신규 메뉴 등록용 핸들러 메소드 호출");
            // 'mappingResult'라는 이름의 뷰를 반환한다. 이 뷰는 실제로는 '/resources/templates/mappingResult' 경로의 템플릿 파일을 참조한다.
            return "mappingResult";
        }

        /*
        2. 메소드 방식 지정 - HTTP 요청 메소드를 지정하여, 해당 요청 메소드로 들어오는 요청n3만을 처리할 수 있다.
        */
        @RequestMapping(value = "/menu/modify", method = RequestMethod.GET) // GET 방식의 '/menu/modify' 요청을 처리한다.
        public String modifyMenu(Model model){
            // model 객체에 message라는 이름의 속성을 추가한다. 이 속성은 뷰에서 사용될 수 있다.
            model.addAttribute("message", "Get방식의 메뉴 수정 호출");
            // 'mappingResult'라는 이름의 뷰를 반환한다.
            return "mappingResult";
        }

    /*
    3. 요청 메소드 전용 어노테이션 - 특정 HTTP 요청 메소드에 대해서만 동작하는 어노테이션들이다.
    요청 메소드          어노테이션
    POST              @PostMapping
    GET               @GetMapping
    PUT               @PutMapping
    DELETE            @DeleteMapping
    PATCH             @PatchMapping
    */

    @GetMapping("/menu/delete")
    public String getDeleteMenu(Model model){
        model.addAttribute("message", "get방식의 삭제용 핸들러 메소드 호출");
        return "mappingResult";
    }

    @PostMapping("/menu/delte")
    public String postDeletemenu(Model model){
        model.addAttribute("message","Post방식의 삭제용 핸들러 메소드 호출");
        return "mappingResult";
    }



}

