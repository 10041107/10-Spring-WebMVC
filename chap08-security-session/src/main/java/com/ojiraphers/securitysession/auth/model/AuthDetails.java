package com.ojiraphers.securitysession.auth.model;

import com.ojiraphers.securitysession.user.model.dto.LoginUserDTO;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

public class AuthDetails implements UserDetails {

    private LoginUserDTO loginUserDTO;
    private Object role;

    public AuthDetails(LoginUserDTO login){
        this.loginUserDTO=loginUserDTO;
    }



    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        loginUserDTO.getUserRole().forEach(role -> authorities.add(() -> role));

        return authorities;
    }

    /**
     * 사용자의 비밀번호를 반환하는 메서드이다.
     * 유저네임페스워드오토메티케이션토큰과 사용자의 비밀번호를 공유할때 사용됨
     * @return
     */
    @Override
    public String getPassword() {
        return null;
    }

    /**
     * 사용자의 아이디를 반환하는 메서드이다.
     * 유저네임페스워드오토메티케이션토큰과 사용자의 아이디를 공유할때 사용됨
     * @return
     */
    @Override
    public String getUsername() {
        return loginUserDTO.getUserName();
    }

    /**
     * 계정 만료 여부를 표현하는 메소드
     * flace면 해당계정을 사용할 수 없다
     *
     * @return
     */
    @Override
    public boolean isAccountNonExpired() {
        return Boolean.parseBoolean(loginUserDTO.getPassword());
    }
    /**
     * 계정 만료 여부를 표현하는 메소드
     * flase면 해당계정을 사용할 수 없다
     *
     * 비밀번호 반복 실패로 일시적인 계정 lock과 같은 경우
     * 혹은 오랜 기간 비접속으로 휴면처리
     * @return
     */
    @Override
    public boolean isAccountNonLocked() {
        return false;
    }


    /**
     * 탈퇴 계정 여부를 표현하는 메서드
     * false면 해당 계정을 사용할 수 없다
     * 보통 데이터 삭제는 즉시 하는것이 아닌 일정 기간 보관 후 삭제를 한다.
     * =데이터 삭제 유예 단계
     * @return
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }


    /**
     * 계정 비활성화 여부로 사용자가 사용할 수 없는 상태
     * false면 계정을 사용할 수 없다
     *
     * 삭제 처리와 같은 경우
     * =데이터 삭제 단계
     * @return
     */
    @Override
    public boolean isEnabled() {
        return false;
    }
}
