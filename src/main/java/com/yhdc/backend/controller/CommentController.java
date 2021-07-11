package com.yhdc.backend.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yhdc.backend.dto.CommentDTO;
import com.yhdc.backend.service.CommentService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/comment")
@Log4j2
@RequiredArgsConstructor
public class CommentController {
	
	private final CommentService commentService;
	
	@GetMapping(value = "/board/{bno}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<CommentDTO>> getListByBoard(@PathVariable("bno") Long bno){
		
		log.info("bno: " + bno);
		
		return new ResponseEntity<>(commentService.getList(bno), HttpStatus.OK);
	}
	
	@PostMapping("")
	public ResponseEntity<Long> register(@RequestBody CommentDTO commentDTO){
		
		log.info(commentDTO);
		
		Long cno = commentService.register(commentDTO);
		
		return new ResponseEntity<>(cno, HttpStatus.OK);
	}	
	
	
	@DeleteMapping("/{cno}")
	public ResponseEntity<String> remove(@PathVariable("cno") Long cno){
		
		log.info("CNO: " + cno);
		
		commentService.remove(cno);
		
		return new ResponseEntity<>("success", HttpStatus.OK);
	}
	
	@PutMapping("/{cno}")
	public ResponseEntity<String> modify(@RequestBody CommentDTO commentDTO){
		
		log.info(commentDTO);
		
		commentService.modify(commentDTO);
		
		return new ResponseEntity<>("success", HttpStatus.OK);
	}
}
