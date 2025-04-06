package com.example.board.service.impl;

import com.example.board.repository.BoardRepository;
import com.example.board.repository.entity.Board;
import com.example.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * 게시판 서비스 구현체
 */
@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

    private final BoardRepository boardRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Board> findAll() {
        return boardRepository.findAllByOrderByCreatedDateDesc();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Board> findById(UUID id) {
        return boardRepository.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Board> findByTitle(String title) {
        return boardRepository.findByTitleContainingOrderByCreatedDateDesc(title);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Board> findByAuthor(String author) {
        return boardRepository.findByAuthorContainingOrderByCreatedDateDesc(author);
    }

    @Override
    @Transactional
    public Board save(Board board) {
        return boardRepository.save(board);
    }

    @Override
    @Transactional
    public void deleteById(UUID id) {
        boardRepository.deleteById(id);
    }
}
