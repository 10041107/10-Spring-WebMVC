package com.ojiraphers.pos.menu.model;

import com.ojiraphers.pos.dto.MenuDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MenuDAO {
    List<MenuDTO> selectAllMenu();
}
