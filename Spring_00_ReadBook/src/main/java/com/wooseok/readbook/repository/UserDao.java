package com.wooseok.readbook.repository;

import com.wooseok.readbook.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserDao extends JpaRepository<User, Long> {

    public Optional<User> findByUserid(String userid);
}
