package com.example.querydsl.domain.team.dto;


import com.querydsl.core.annotations.QueryProjection;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class TeamInfoDto {

  private String name;
  private Long id;

  @QueryProjection
  public TeamInfoDto(String name, Long id) {
    this.name = name;
    this.id = id;
  }
}
