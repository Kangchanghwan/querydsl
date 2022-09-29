package com.example.querydsl.domain.user.entity;

import com.example.querydsl.domain.team.entity.Team;
import com.example.querydsl.domain.user.vo.UserInfoReq;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
@Setter
@Table(name = "user_tb")
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "user_id")
  private Long id;
  private String nickName;
  private Integer age;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "team_id")
  private Team team;

  public static User UserInfoReqToEntity(UserInfoReq userInfoReq, Team team) {
    return User.builder().age(userInfoReq.getAge())
                         .nickName(userInfoReq.getName())
                         .team(team)
                .build();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
    User user = (User) o;
    return id != null && Objects.equals(id, user.id);
  }

  @Override
  public int hashCode() {
    return getClass().hashCode();
  }
}
