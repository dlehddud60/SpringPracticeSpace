package com.example.crudexample8.repository;

import com.example.crudexample8.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board,Long> {
    List<Board> findAllByOrderByNoDesc();
}
