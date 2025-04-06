package com.example.board.repository;

import com.example.board.repository.entity.Board;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface BoardRepository extends JpaRepository<Board, UUID> {
    List<Board> findAllByOrderByCreatedDateDesc();
    List<Board> findByTitleContainingOrderByCreatedDateDesc(String title);
    List<Board> findByAuthorContainingOrderByCreatedDateDesc(String author);

    @NotNull Optional<Board> findById(@NotNull UUID id);
}
