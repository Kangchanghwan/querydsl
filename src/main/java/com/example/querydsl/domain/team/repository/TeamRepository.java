package com.example.querydsl.domain.team.repository;


import com.example.querydsl.domain.team.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team,Long>, TeamSearchQueryRepository {

}
