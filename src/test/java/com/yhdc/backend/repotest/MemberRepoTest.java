package com.yhdc.backend.repotest;

import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.yhdc.backend.model.Member;
import com.yhdc.backend.repository.MemberRepository;

@SpringBootTest
public class MemberRepoTest {

	@Autowired
	private MemberRepository memberRepository;

	@Test
	public void insertMembers() {

		IntStream.rangeClosed(1, 50).forEach(i -> {

			Member member = Member.builder().username("USER" + i).password("pass" + i).email("user" + i + "@aaa.com")
					.lastname("choi" + i).firstname("Daniel" + i).phone("1231234").address("AbcSt. Toronto Canada")
					.role("Developer").authority("Admin").active(true).build();

			memberRepository.save(member);
		});
	}
}
