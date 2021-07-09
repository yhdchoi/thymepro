package com.yhdc.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.yhdc.backend.model.Board;
import com.yhdc.backend.model.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {

	@Modifying
	@Query("delete from Comment c where c.board.bno =:bno")
	void deleteByBno(Long bno);
	
	List<Comment> getCommentsByBoardOrderByCno(Board board);
}
