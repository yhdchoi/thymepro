package com.yhdc.backend.repotest;

import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.yhdc.backend.model.Board;
import com.yhdc.backend.model.Comment;
import com.yhdc.backend.repository.CommentRepository;

@SpringBootTest
public class CommentRepoTest {

	@Autowired
	private CommentRepository commentRepository;

	@Test
	public void insertReplies() {

		IntStream.rangeClosed(1, 100).forEach(i -> {

			Long no = (long) (Math.random() * 50) + 1;

			Board board = Board.builder().bno(no).build();

			Comment comment = Comment.builder().writer("guest" + i).content("Content..." + i).privacy(false)
					.board(board).build();

			commentRepository.save(comment);
		});
	}
}
