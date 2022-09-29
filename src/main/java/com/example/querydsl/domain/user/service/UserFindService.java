package com.example.querydsl.domain.user.service;

import com.example.querydsl.domain.user.entity.User;
import com.example.querydsl.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserFindService {

  private final UserRepository userRepository;


  public User findOne(Long id){
    return userRepository.findById(id).orElseThrow( () -> {throw new AssertionError("없어 그런 친구");});
  }
  public User findByName(String name){
    return userRepository.findByNickName(name).orElseThrow(() -> {throw new AssertionError("없다고 그런 친구");});
  }

}
