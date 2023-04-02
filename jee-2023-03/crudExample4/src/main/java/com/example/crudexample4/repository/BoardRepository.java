package com.example.crudexample4.repository;

import com.example.crudexample4.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board,Long> {
}
