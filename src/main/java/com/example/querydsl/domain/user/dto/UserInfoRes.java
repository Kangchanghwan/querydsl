package com.example.querydsl.domain.user.dto;

import com.example.querydsl.domain.user.entity.User;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserInfoRes {

  private String name;
  private Integer age;
  private String teamName;
  private Long teamId;


  public static UserInfoRes makeUserRes(User user){
    return
      UserInfoRes.builder().name(user.getNickName())
      .age(user.getAge())
      .teamName(user.getTeam().getName())
      .teamId(user.getTeam().getId())
      .build();

  }

}
