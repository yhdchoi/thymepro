package com.yhdc.backend.repository.search;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.yhdc.backend.model.Board;

public interface SearchBoardRepository {

	Board search1();
	
	Page<Object[]> searchPage(String type, String keyword, Pageable pageable);
}
