package com.example.querydsl.domain.user.service;

import com.example.querydsl.domain.team.entity.Team;
import com.example.querydsl.domain.team.service.TeamFindService;
import com.example.querydsl.domain.user.entity.User;
import com.example.querydsl.domain.user.repository.UserRepository;
import com.example.querydsl.domain.user.vo.UserInfoReq;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class UserSaveService {

  private final UserRepository userRepository;
  private final TeamFindService teamFindService;


  public User saveUser(UserInfoReq userInfoReq){
    Team team = teamFindService.findOne(userInfoReq.getTeamId());
    return userRepository.save(User.UserInfoReqToEntity(userInfoReq,team));
  }

}
