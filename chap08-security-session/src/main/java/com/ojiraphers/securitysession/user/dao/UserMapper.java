package com.ojiraphers.securitysession.user.dao;

import com.ojiraphers.securitysession.user.model.dto.LoginUserDTO;
import com.ojiraphers.securitysession.user.model.dto.SignupDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    int regist(SignupDTO signupDTO);


    LoginUserDTO findByUsername(String username);
}
