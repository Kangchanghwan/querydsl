package com.example.querydsl.domain.user.repository;

import com.example.querydsl.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
  Optional<User> findByNickName(String nickName);
}
