package com.ojiraphers.pos.menu.controller;

import com.ojiraphers.pos.dto.MenuDTO;
import com.ojiraphers.pos.menu.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping("menus")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @GetMapping("/menu")
    public ModelAndView selectAllMenu(ModelAndView mv){
        List<MenuDTO> menus = menuService.selectAllMenu();

        if(Objects.isNull(menus)){
            System.out.println("excaption으로 대체함");
        }

        mv.addObject("menus", menus);

        mv.setViewName("menu/allMenus");
        return mv;
    }


}
