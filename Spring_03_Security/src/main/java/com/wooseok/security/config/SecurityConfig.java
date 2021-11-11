package com.wooseok.security.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/login").permitAll()
                .anyRequest().authenticated();

        http.formLogin();

        /**
         * Spring Security 에서 form 으로 데이터를 전송할 때
         * 보통 POST 로 전송을 하는데
         * POST 로 전송을 할때는 반드시 _csrf.token 값을
         * 데이터에 포함하여 전송을 해야 한다.
         *
         * form 을 만들때, JSP, thymeleaf 등의 taglib 등을 사용하면
         * 자동으로 _csrf.token 을 form 에 포함시키는 코드를
         * 만들어 준다
         *
         * 최근 Spring Security 정책이
         * https (Hypertext Transfer Protocol Secure) 가 적용된 곳에서는
         * 정상적으로 _csrf.token 을 form 에 추가를 한다
         *
         * 그런데 http 로 되어있는 곳에는 정상적으로 추가하지 않는다
         *
         * http 로 테스트를 하는 경우는 아래 속성을 추가해 주어야 한다
         */
        http.csrf()
                .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.inMemoryAuthentication()
                .withUser("wooseok")
                .password("{noop}1234")
                .roles("ADMIN");
    }
}
