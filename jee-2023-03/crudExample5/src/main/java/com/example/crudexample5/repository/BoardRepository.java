package com.example.crudexample5.repository;

import com.example.crudexample5.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {

}
