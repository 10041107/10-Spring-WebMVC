package com.ojiraphers.securitysession.user.service;

import com.ojiraphers.securitysession.user.dao.UserMapper;
import com.ojiraphers.securitysession.user.model.dto.LoginUserDTO;
import com.ojiraphers.securitysession.user.model.dto.SignupDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
public class MemberService {
    private UserMapper userMapper;
    private PasswordEncoder encoder;

    @Autowired
    public MemberService(UserMapper userMapper, PasswordEncoder encoder) {
        this.userMapper = userMapper;
        this.encoder = encoder;
    }

    @Transactional
    public int regist(SignupDTO signupDTO) {
        signupDTO.setUserPass(encoder.encode(signupDTO.getUserPass()));
        int result = userMapper.regist(signupDTO);

        return result;
    }

    public LoginUserDTO findBuUsername(String username) {

        LoginUserDTO login = userMapper.findByUsername(username);
        if(Objects.isNull(login)){
            return login;
        }else {
            return null;
        }
    }
}
