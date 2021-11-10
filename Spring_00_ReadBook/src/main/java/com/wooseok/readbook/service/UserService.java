package com.wooseok.readbook.service;

import com.wooseok.readbook.config.CustomPasswordEncoder;
import com.wooseok.readbook.models.User;
import com.wooseok.readbook.models.UserDTO;
import com.wooseok.readbook.repository.UserDao;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    private final UserDao uDao;

    public UserService(UserDao uDao) {
        this.uDao = uDao;
    }

    @Override
    public UserDetails loadUserByUsername(String userid) throws UsernameNotFoundException {
        return uDao.findByUserid(userid).orElseThrow(() -> new UsernameNotFoundException(userid));
    }

    public void insert(UserDTO userDTO) {
        CustomPasswordEncoder encoder = new CustomPasswordEncoder();
        userDTO.setPassword(encoder.encode(userDTO.getPassword()));

        uDao.save(User.builder()
                .userid(userDTO.getUserid())
                .password(userDTO.getPassword())
                .auth(userDTO.getAuth()).build());

    }
}
