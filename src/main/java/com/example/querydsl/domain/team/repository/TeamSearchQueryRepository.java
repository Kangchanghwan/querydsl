package com.example.querydsl.domain.team.repository;

import com.example.querydsl.domain.team.dto.TeamInfoDto;

import java.util.Optional;

public interface TeamSearchQueryRepository {

  Optional<TeamInfoDto> searchTeam(String name);

}
