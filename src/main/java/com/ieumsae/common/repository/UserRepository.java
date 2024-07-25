package com.ieumsae.common.repository;

import com.ieumsae.common.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    
    // userId로 관련된 정보를 조회
    User findByUserId(Long userId);
}
