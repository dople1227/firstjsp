package com.example.board.controller.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.example.board.repository.entity.Board;

/**
 * 게시글 생성 및 수정 요청에 사용되는 DTO 클래스
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BoardRequestDto {

    @NotBlank(message = "제목은 필수 입력값입니다.")
    @Size(min = 2, max = 100, message = "제목은 2자 이상 100자 이하로 입력해주세요.")
    private String title;

    @NotBlank(message = "내용은 필수 입력값입니다.")
    private String content;

    @NotBlank(message = "작성자는 필수 입력값입니다.")
    @Size(min = 2, max = 50, message = "작성자는 2자 이상 50자 이하로 입력해주세요.")
    private String author;

    /**
     * DTO를 Entity로 변환
     */
    public Board toEntity() {
        return Board.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }
}
