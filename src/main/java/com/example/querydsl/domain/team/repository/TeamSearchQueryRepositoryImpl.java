package com.example.querydsl.domain.team.repository;

import com.example.querydsl.domain.team.dto.QTeamInfoDto;
import com.example.querydsl.domain.team.dto.TeamInfoDto;
import com.example.querydsl.domain.team.entity.QTeam;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import static com.example.querydsl.domain.team.entity.QTeam.*;

@RequiredArgsConstructor
public class TeamSearchQueryRepositoryImpl implements TeamSearchQueryRepository {

  private final JPAQueryFactory queryFactory;

  @Override
  public Optional<TeamInfoDto> searchTeam(String name) {

    return Optional.ofNullable(
      queryFactory
      .select(new QTeamInfoDto(team.name, team.id))
      .from(team)
      .where(team.name.eq(name)).fetchOne());

  }
}
