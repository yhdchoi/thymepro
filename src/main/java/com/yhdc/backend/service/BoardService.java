package com.yhdc.backend.service;

import com.yhdc.backend.dto.BoardDTO;
import com.yhdc.backend.model.Board;
import com.yhdc.backend.model.Member;
import com.yhdc.backend.page.PageRequestDTO;
import com.yhdc.backend.page.PageResultDTO;

public interface BoardService {

	Long register(BoardDTO dto);

	PageResultDTO<BoardDTO, Object[]> getList(PageRequestDTO pageRequestDTO);

	// Get Board with BoardID
	BoardDTO get(Long bno);

	// Delete Board with BoardID
	void removeWithReplies(Long bno);
	
	// Modify Board
	void modify(BoardDTO boardDTO);

	// List Board
	default BoardDTO entityToDTO(Board board, Member member, Long commentCount) {

		BoardDTO boardDTO = BoardDTO.builder().bno(board.getBno()).title(board.getTitle()).content(board.getContent())
				.privacy(board.isPrivacy()).writerId(member.getMno()).writerUsername(member.getUsername())
				.regDate(board.getRegDate()).modDate(board.getModDate()).commentCount(commentCount.intValue()).build();

		return boardDTO;
	}

	// Post Board
	default Board dtoToEntity(BoardDTO dto) {

		Member member = Member.builder().mno(dto.getWriterId()).build();

		Board board = Board.builder().bno(dto.getBno()).title(dto.getTitle()).content(dto.getContent())
				.privacy(dto.isPrivacy()).writer(member).build();

		return board;
	}
}
