package com.yhdc.backend.repotest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.yhdc.backend.repository.BoardRepository;

@SpringBootTest
public class BoardRepoTest {

	@Autowired
	private BoardRepository boardRepository;

//	@Test
//	public void insertBoards() {
//		IntStream.rangeClosed(1, 50).forEach(i -> {
//
//			Long no = (long) (Math.random() * 50) + 1;
//
//			Member member = Member.builder().mno(no).build();
//
//			Board board = Board.builder().title("Title..." + i).content("Content..." + i).privacy(false).writer(member)
//					.build();
//
//			boardRepository.save(board);
//		});
//	}
	
//	@Test
//	public void testGetBoardWithReply() {
//		List<Object[]> result =boardRepository.getBoardWithReply(16L);
//		
//		for (Object[] arr : result) {
//			System.out.println(Arrays.toString(arr));
//		}
//	}
	
	
//	@Test
//	public void testSearch1() {
//		boardRepository.search1();
//	}
	
	
	@Test
	public void testSearchPage() {
		Pageable pageable = PageRequest.of(0, 10, Sort.by("bno").descending().and(Sort.by("title").ascending()));
		
		Page<Object[]> result = boardRepository.searchPage("t", "1", pageable);
		
		
	}
}
