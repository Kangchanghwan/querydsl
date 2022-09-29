package com.example.querydsl.domain.team.service;

import com.example.querydsl.domain.team.dto.TeamInfoDto;
import com.example.querydsl.domain.team.entity.Team;
import com.example.querydsl.domain.team.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.function.Supplier;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class TeamFindService {

  private final TeamRepository teamRepository;

  public List<Team> findAllTeam(){
    return teamRepository.findAll();
  }
  public Team findOne(Long id){
    return teamRepository.findById(id).orElseThrow(notFoundTeamException("팀 없어"));
  }

  private Supplier<RuntimeException> notFoundTeamException(String 팀_없어) {
    return () -> {
      throw new AssertionError(팀_없어);
    };
  }

  public TeamInfoDto findByTeamName(String name) {
    return teamRepository.searchTeam(name).orElseThrow(notFoundTeamException("팀 없엄"));
  }

}
