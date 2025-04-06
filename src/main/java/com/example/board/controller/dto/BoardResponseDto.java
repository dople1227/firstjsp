package com.example.board.controller.dto;

import com.example.board.repository.entity.Board;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

/**
 * 게시글 조회 응답에 사용되는 DTO 클래스
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BoardResponseDto {

    private UUID id;
    private String title;
    private String content;
    private String author;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;
    private String formattedCreatedDate;
    private String formattedModifiedDate;

    /**
     * Entity를 DTO로 변환
     */
    public static BoardResponseDto fromEntity(Board board) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        
        String formattedCreatedDate = null;
        if (board.getCreatedDate() != null) {
            formattedCreatedDate = board.getCreatedDate().format(formatter);
        }
        
        String formattedModifiedDate = null;
        if (board.getModifiedDate() != null) {
            formattedModifiedDate = board.getModifiedDate().format(formatter);
        }
        
        return BoardResponseDto.builder()
                .id(board.getId())
                .title(board.getTitle())
                .content(board.getContent())
                .author(board.getAuthor())
                .createdDate(board.getCreatedDate())
                .modifiedDate(board.getModifiedDate())
                .formattedCreatedDate(formattedCreatedDate)
                .formattedModifiedDate(formattedModifiedDate)
                .build();
    }
}
