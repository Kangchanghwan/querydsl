package com.example.querydsl.domain.team.controller;

import com.example.querydsl.domain.team.dto.TeamInfoDto;
import com.example.querydsl.domain.team.entity.Team;
import com.example.querydsl.domain.team.service.TeamFindService;
import com.example.querydsl.domain.team.service.TeamSaveService;
import com.example.querydsl.domain.team.vo.TeamInfoReq;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class TeamController {

  private final TeamSaveService teamSaveService;
  private final TeamFindService teamFindAllService;

  @PostMapping("/teams")
  @ResponseStatus(value = HttpStatus.OK)
  public ResponseEntity<Team> save(@RequestBody TeamInfoReq teamInfoReq){
    return ResponseEntity.ok(teamSaveService.save(teamInfoReq));
  }
//  @GetMapping("/teams")
//  @ResponseStatus(value = HttpStatus.OK)
//  public ResponseEntity<List<Team>> findAll(){
//    return ResponseEntity.ok(teamFindAllService.findAllTeam());
//  }

  @GetMapping("/teams")
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<TeamInfoDto> findByName(@RequestParam String name){
    return ResponseEntity.ok(teamFindAllService.findByTeamName(name));
  }

}
