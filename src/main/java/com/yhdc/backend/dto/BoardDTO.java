package com.yhdc.backend.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BoardDTO {
    
    private Long bno;
    private String title;
    private String content;
    private boolean privacy;

    private Long writerId;
    private String writerUsername;

    private LocalDateTime regDate;
    private LocalDateTime modDate;

    private int commentCount;
}
