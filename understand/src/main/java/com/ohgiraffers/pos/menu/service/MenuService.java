package com.ohgiraffers.pos.menu.service;

import com.ohgiraffers.pos.menu.dto.MenuDTO;
import com.ohgiraffers.pos.menu.model.MenuDao;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class MenuService {

    private MenuDao menuDao;

    public MenuService(MenuDao menuDao) {
        this.menuDao = menuDao;
    }

    public List<MenuDTO> selectAllMenu() {

       List<MenuDTO> menus = menuDao.selecAllMenu();

       if(Objects.isNull(menus)){
           System.out.println("exeception menus가 없네요");
       }


       return menus;
    }
}
