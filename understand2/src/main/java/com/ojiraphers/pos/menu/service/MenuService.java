package com.ojiraphers.pos.menu.service;

import com.ojiraphers.pos.menu.dto.MenuDTO;
import com.ojiraphers.pos.menu.model.MenuDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class MenuService {

    @Autowired
    private MenuDAO menuDAO;

    public List<MenuDTO> selectAllMenu() {
        List<MenuDTO> menus = menuDAO.selectAllMenu();
        if (Objects.isNull(menus)) {
            System.out.println("exception menus가 없네요");
        }
        return menus;
    }
}