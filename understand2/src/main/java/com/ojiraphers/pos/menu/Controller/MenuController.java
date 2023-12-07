package com.ojiraphers.pos.menu.Controller;

import com.ojiraphers.pos.menu.dto.MenuDTO;
import com.ojiraphers.pos.menu.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Objects;

@Controller // Controller 어노테이션을 사용하여 스프링이 이 클래스를 컨트롤러로 인식하게 합니다.
@RequestMapping() // 클래스 레벨의 RequestMapping 어노테이션. 모든 메소드에 공통적으로 적용되는 URL 경로를 지정할 수 있습니다.
public class MenuController {

    @Autowired // 의존성 주입을 위한 어노테이션. MenuService를 자동으로 주입받습니다.
    private MenuService menuService;

    @GetMapping("/menu") // "/menu" 경로로 GET 요청이 오면 이 메소드가 처리합니다.
    public ModelAndView selectAllMenu(ModelAndView mv){
        List<MenuDTO> menus = menuService.selectAllMenu(); // 모든 메뉴를 조회합니다.

        if(Objects.isNull(menus)){ // 메뉴 목록이 null인 경우 예외를 출력합니다.
            System.out.println("exception으로 대체함");
        }

        mv.addObject("menus", menus); // 뷰에 메뉴 목록을 추가합니다.

        mv.setViewName("menu/allMenus"); // 뷰의 이름을 "menu/allMenus"로 설정합니다.
        return mv; // 설정된 ModelAndView 객체를 반환합니다.
    }


    @PutMapping("/menu-Register") // "/menu-Register" 경로로 GET 요청이 오면 이 메소드가 처리합니다.
    public ModelAndView RegisterMenu(ModelAndView mv){

        return mv;
    }

    @PutMapping("/menu-update") // "/menu-Register" 경로로 GET 요청이 오면 이 메소드가 처리합니다.
    public ModelAndView updateMenu(ModelAndView mv){

        return mv;
    }

}

