package com.ojiraphers.securitysession.config;

import com.ojiraphers.securitysession.common.UserRole;
import com.ojiraphers.securitysession.config.handler.AuthFailHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.AntPathRequestMatcherProvider;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private AuthFailHandler authFailHandler;

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer(){
        return web -> web.ignoring().requestMatchers(PathRequest.toStaticResources().atCommonLocations());
    }

    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        try {
            http.authorizeHttpRequests(auth -> {
                auth.requestMatchers("/auth/login", "/user/signup", "/auth/", "/").permitAll();
                auth.requestMatchers("/admin/*").hasAnyAuthority(UserRole.ADMIN.getRole());
                auth.requestMatchers("/user/*").hasAnyAuthority(UserRole.USER.getRole());
                auth.anyRequest().authenticated();
            }).formLogin((login -> {
                login.loginPage("/auth/login");
                login.usernameParameter("user");
                login.passwordParameter("pass");
                login.defaultSuccessUrl("/");
                login.failureHandler(authFailHandler);
            })).logout(logout -> {
                logout.logoutRequestMatcher(new AntPathRequestMatcher("/auth/logout"));
                logout.deleteCookies("JSESSIONID");
                logout.invalidateHttpSession(true);
                logout.logoutSuccessUrl("/"); // 세션을 소멸하도록 허용하는 것
            }).sessionManagement(session -> {
                session.maximumSessions(1); // session의 허용 개수를 제한
                session.invalidSessionUrl("/"); // 세션 만료시 이동할 페이지

            }).csrf(csrf -> csrf.disable());

            return http.build();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}