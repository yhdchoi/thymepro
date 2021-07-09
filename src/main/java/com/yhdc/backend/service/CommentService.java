package com.yhdc.backend.service;

import java.util.List;

import com.yhdc.backend.dto.CommentDTO;
import com.yhdc.backend.model.Board;
import com.yhdc.backend.model.Comment;

public interface CommentService {

	Long register(CommentDTO commentDTO);

	List<CommentDTO> getList(Long bno);

	void modify(CommentDTO commentDTO);

	void remove(Long cno);

	default Comment dtoToEntity(CommentDTO commentDTO) {

		Board board = Board.builder().bno(commentDTO.getBno()).build();

		Comment comment = Comment.builder().cno(commentDTO.getCno()).writer(commentDTO.getWriter())
				.content(commentDTO.getContent()).privacy(false).board(board).build();

		return comment;
	}

	default CommentDTO entityToDTO(Comment comment) {
		CommentDTO dto = CommentDTO.builder().cno(comment.getCno()).writer(comment.getWriter())
				.content(comment.getContent()).privacy(false).regDate(comment.getRegDate())
				.modDate(comment.getModDate()).build();

		return dto;
	}

}
