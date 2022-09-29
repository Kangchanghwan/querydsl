package com.example.querydsl.domain.team.entity;


import com.example.querydsl.domain.team.vo.TeamInfoReq;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
@Table(name = "team_tb")
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder

public class Team {

  @Column(name="team_id")
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;



  public static Team TeamInfoToEntity(TeamInfoReq teamInfoReq){
    return Team.builder().name(teamInfoReq.getName()).build();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
    Team team = (Team) o;
    return id != null && Objects.equals(id, team.id);
  }

  @Override
  public int hashCode() {
    return getClass().hashCode();
  }
}
