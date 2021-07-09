package com.yhdc.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yhdc.backend.model.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {

}
