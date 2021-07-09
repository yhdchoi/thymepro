package com.yhdc.backend.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.yhdc.backend.model.Board;
import com.yhdc.backend.repository.search.SearchBoardRepository;

public interface BoardRepository extends JpaRepository<Board, Long>, SearchBoardRepository {

	// Board with Writer
		@Query("SELECT b, w FROM Board b LEFT JOIN b.writer w WHERE b.bno = :bno")
		Object getBoardWithWriter(@Param("bno") Long bno);

		// Board with Reply
		@Query("SELECT b, c FROM Board b LEFT JOIN Comment c ON c.board = b WHERE b.bno = :bno")
		List<Object[]> getBoardWithReply(@Param("bno") Long bno);

		// Board with ReplyCount
		@Query(value = "SELECT b, w, count(c) FROM Board b LEFT JOIN b.writer w LEFT JOIN Comment c ON c.board = b GROUP BY b", countQuery = "SELECT count(b) FROM Board b")
		Page<Object[]> getBoardWithReplyCount(Pageable pageable);

		// Get with BoardID
		@Query("SELECT b, w, count(c) FROM Board b LEFT JOIN b.writer w LEFT OUTER JOIN Comment c ON c.board = b WHERE b.bno = :bno")
		Object getBoardByBno(@Param("bno") Long bno);
}
