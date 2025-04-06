package com.example.board.service;

import com.example.board.repository.entity.Board;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * 게시판 서비스 인터페이스
 */
public interface BoardService {

    /**
     * 모든 게시글을 작성일 기준 내림차순으로 조회
     * @return 게시글 목록
     */
    List<Board> findAll();

    /**
     * ID로 게시글 조회
     * @param id 게시글 ID
     * @return 게시글 Optional 객체
     */
    Optional<Board> findById(UUID id);

    /**
     * 제목에 키워드가 포함된 게시글 조회
     * @param title 검색할 제목 키워드
     * @return 게시글 목록
     */
    List<Board> findByTitle(String title);

    /**
     * 작성자명에 키워드가 포함된 게시글 조회
     * @param author 검색할 작성자 키워드
     * @return 게시글 목록
     */
    List<Board> findByAuthor(String author);

    /**
     * 게시글 저장 (등록 또는 수정)
     * @param board 저장할 게시글 객체
     * @return 저장된 게시글 객체
     */
    Board save(Board board);

    /**
     * ID로 게시글 삭제
     * @param id 삭제할 게시글 ID
     */
    void deleteById(UUID id);
}
