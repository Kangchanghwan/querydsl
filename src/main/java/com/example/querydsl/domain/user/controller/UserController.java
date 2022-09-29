package com.example.querydsl.domain.user.controller;

import com.example.querydsl.domain.user.dto.UserInfoRes;
import com.example.querydsl.domain.user.entity.User;
import com.example.querydsl.domain.user.service.UserFindService;
import com.example.querydsl.domain.user.service.UserSaveService;
import com.example.querydsl.domain.user.vo.UserInfoReq;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class UserController {

  private final UserSaveService userSaveService;
  private final UserFindService userFindService;


  @PostMapping("/users")
  public ResponseEntity<User> save(@RequestBody UserInfoReq userInfoReq){
    return ResponseEntity.ok(userSaveService.saveUser(userInfoReq));
  }

//  @GetMapping("/users/{id}")
//  public ResponseEntity<UserInfoRes> findOnd(@PathVariable Long id){
//    return ResponseEntity.ok(UserInfoRes.makeUserRes(userFindService.findOne(id)));
//  }

  @GetMapping("/users")
  public ResponseEntity<UserInfoRes> findOne(@RequestParam String name) {
    return ResponseEntity.ok(UserInfoRes.makeUserRes(userFindService.findByName(name)));
  }
}

