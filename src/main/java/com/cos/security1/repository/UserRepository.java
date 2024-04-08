package com.cos.security1.repository;

import com.cos.security1.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

// crud 함수를 JpaRepository가 들고 있음
// @Repository라는 어노테이션이 없어도 IoC가 됨
// JpaRepository를 상속했기 때문
public interface UserRepository extends JpaRepository<User, Long> {
    // findBy규칙 -> Username문법
    // select * from user where username = ?
    public User findByUsername(String username);
}
