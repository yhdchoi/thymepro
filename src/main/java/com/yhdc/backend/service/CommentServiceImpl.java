package com.yhdc.backend.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.yhdc.backend.dto.CommentDTO;
import com.yhdc.backend.model.Board;
import com.yhdc.backend.model.Comment;
import com.yhdc.backend.repository.CommentRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

	private final CommentRepository commentRepository; 
	
	@Override
	public Long register(CommentDTO commentDTO) {
		
		Comment comment = dtoToEntity(commentDTO);
		
		commentRepository.save(comment);
		
		return comment.getCno();		
	}
	
	@Override
	public List<CommentDTO> getList(Long bno) {
		List<Comment> result = commentRepository.getCommentsByBoardOrderByCno(Board.builder().bno(bno).build());
		
		return result.stream().map(comment -> entityToDTO(comment)).collect(Collectors.toList());
	}
	
	
	@Override
	public void modify(CommentDTO commentDTO) {
		
		Comment comment = dtoToEntity(commentDTO);
		
		commentRepository.save(comment);
	}
	
	@Override
	public void remove(Long cno) {
		commentRepository.deleteById(cno);
	}
	
}
