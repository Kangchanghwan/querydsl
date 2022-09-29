package com.example.querydsl.domain.team.service;

import com.example.querydsl.domain.team.entity.Team;
import com.example.querydsl.domain.team.repository.TeamRepository;
import com.example.querydsl.domain.team.vo.TeamInfoReq;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class TeamSaveService {

  private final TeamRepository teamRepository;

  public Team save(TeamInfoReq teamInfoReq){
    return teamRepository.save(Team.TeamInfoToEntity(teamInfoReq));
  }
}
