package com.yhdc.backend.servicetest;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.yhdc.backend.dto.CommentDTO;
import com.yhdc.backend.service.CommentService;

@SpringBootTest
public class CommentServiceTest {

	@Autowired
	private CommentService commentService;
	
	@Test
	public void testGetList() {
		
		Long bno = 35L;
		
		List<CommentDTO> commentDTOList = commentService.getList(bno);
		
		commentDTOList.forEach(replyDTO -> System.out.println(replyDTO));
	}
}
