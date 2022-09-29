package com.example.querydsl.domain.user.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserInfoReq {

  private String name;
  private Integer age;
  private Long teamId;

}
