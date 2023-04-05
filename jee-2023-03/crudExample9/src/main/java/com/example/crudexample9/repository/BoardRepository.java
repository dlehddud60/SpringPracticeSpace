package com.example.crudexample9.repository;

import com.example.crudexample9.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {
}
