package com.wooseok.security.service.auth;

import com.wooseok.security.models.User;
import com.wooseok.security.repository.MemberDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * security 에서 login 서비스를 수행하는 방법이 다양하다
 *
 * DB 와 연동을 하여 로그인을 수행하는비교적 쉬운 방법으로
 * UserDetailsService 상속받아 클래스를 만들고 수행한다
 *
 * UserDetailService uds = new LoginService()
 * uds.loadUserByUsername(username)
 */

@Slf4j
@Service("loginService")
public class LoginService implements UserDetailsService {

    private final String encPassword = "$2a$04$eBwOq5KoqjqwN7Zvds4/SOT/rjH0QulBlKQ40zeu98PLFasgvIn8a";

    private final MemberDao memberDao;

    public LoginService(MemberDao memberDao) {
        this.memberDao = memberDao;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        // 1. dao 에서 사용자 정보 가져오기
        // username 으로 member table 에서
        // findById(username) 등을 수행하여
        // User 정보를 가져온다

        User user = User.builder()
                    .username("wooseok")
                    .password(encPassword)
                    .isAccountNonExpired(true)
                    .isEnabled(true)
                    .isCredentialsNonExpired(true)
                    .isAccountNonLocked(false)
                    .build();
//        User user = memberDao.findById(username).get();

        // 2. dao 에서 받은 사용자 정보가 ㅇ벗으면
        //  즉 username 에 저장된 사용자이름이
        //  DB에 없으면
        //  강제로 exception 을 발생하여
        //  security 에게 알려준다
        if(user == null) {
            log.debug("{} username 없음",username);
            throw new UsernameNotFoundException(username + "사용자 없음");
        }

        //=======================
        // security 에 내장된 코드
        // try {
        //     UserDetails vo = loadUserByUsername("wooseok");
            // 비밀번호를 검사하는 코드가 내장되어 있을 것이다
        // } catch (UsernameNotFoundException e) {
            // redirect "/member/login?error=xxxx";
        // }
        //=======================
        return user;
    }
}
