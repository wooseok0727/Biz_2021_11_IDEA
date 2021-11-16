package com.wooseok.security.service.impl;

import com.wooseok.security.models.User;
import com.wooseok.security.repository.MemberDao;
import com.wooseok.security.service.MemberService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("memberServiceV1")
public class MemberServiceImplV1 implements MemberService {

    private final MemberDao memberDao;
    /**
     * security-context.xml 에 선언된 bean 을 가져와서
     * 와이어드 하여 사용할 준비하기
     *
     * bean 으로 이미 선언이 되었기 깨문에
     * final 로 선언하고 생성자에서 주입받기
     */
    private final PasswordEncoder passwordEncoder;

    public MemberServiceImplV1(MemberDao memberDao, PasswordEncoder passwordEncoder) {
        this.memberDao = memberDao;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<User> selectAll() {

        return memberDao.findAll();
    }

    @Override
    public User findById(String username) {

        /**
         * JpaRepository 에 선언된 findById(pk) 는
         * SELECT * FROM [table] WHERE PK = [pk] SQL 을 실행하고
         * 결과를 Optional<User> type 으로 return 을 한다
         * Optional 로 감싸진 데이터는 null safe type 의 데이터이다
         * null 로 뭔가를 검사하려고 하면
         * 문제가 되기도 한다
         *
         * 결과값.orElse(리턴값) method 를 사용하여
         * 결과값이 실제로 null 이면 orElse(리턴값)을 참조하여
         * 그 값을 연산 결과로 return 해준다
         *
         * 이러한 원리를 이용하여
         * findById() 한 결과가 없으면 null 을 return 하도록
         * 만들어 준다.
         */
        return memberDao.findById(username).orElse(null);
    }

    @Override
    public void insert(User user) {

        /**
         * Spring security 에서 제공하는
         * PasswordEncoder(BCryptPasswordEncoder) 를 사용하여
         * 사용자의 비밀번호를 암호화 하기
         */
        String encPassword
                = passwordEncoder.encode(user.getPassword());

        User saveVO
                = User.builder()
                .username(user.getUsername())
                .password(encPassword)
                .isAccountNonExpired(true)
                .isEnabled(true)
                .isCredentialsNonExpired(true)
                .isAccountNonLocked(true)
                .build();

        memberDao.save(saveVO);
    }

    @Override
    public void update(User user) {

    }

    @Override
    public void delete(String s) {

    }

    @Override
    public List<User> findByEmail(String email) {
        return null;
    }

    @Override
    public List<User> findByTel(String tel) {
        return null;
    }

    @Override
    public int userCount() {
        return 0;
    }
}
