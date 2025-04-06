package com.example.board.controller.dto;

import com.example.board.repository.entity.Board;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * 게시글 목록 조회 응답에 사용되는 DTO 클래스
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BoardListResponseDto {

    private UUID id;
    private String title;
    private String author;
    private String createdDate;

    /**
     * Entity를 ListDTO로 변환
     */
    public static BoardListResponseDto fromEntity(Board board) {
        String formattedDate = board.getCreatedDate() != null ? 
                board.getCreatedDate().toLocalDate().toString() : null;
        
        return BoardListResponseDto.builder()
                .id(board.getId())
                .title(board.getTitle())
                .author(board.getAuthor())
                .createdDate(formattedDate)
                .build();
    }

    /**
     * Entity 리스트를 DTO 리스트로 변환
     */
    public static List<BoardListResponseDto> fromEntityList(List<Board> boards) {
        return boards.stream()
                .map(BoardListResponseDto::fromEntity)
                .collect(Collectors.toList());
    }
}
