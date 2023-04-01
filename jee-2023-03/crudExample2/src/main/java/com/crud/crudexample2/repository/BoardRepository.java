package com.crud.crudexample2.repository;

import com.crud.crudexample2.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board,Long> {
}
