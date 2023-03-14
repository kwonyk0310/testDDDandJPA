package com.example.demo.test.domain.repository;

import com.example.demo.test.domain.model.aggregates.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {

}
