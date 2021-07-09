package com.yhdc.backend.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CommentDTO {
    
    private Long cno;
    private String writer;
    private String content;
    private boolean privacy;

    private Long bno;

    private LocalDateTime regDate;
    private LocalDateTime modDate;
}
