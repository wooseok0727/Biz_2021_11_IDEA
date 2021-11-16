package com.wooseok.security.repository;

import com.wooseok.security.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberDao extends JpaRepository<User, String> {

}
