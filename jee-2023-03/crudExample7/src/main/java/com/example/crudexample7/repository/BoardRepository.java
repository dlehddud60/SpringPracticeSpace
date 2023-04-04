package com.example.crudexample7.repository;

import com.example.crudexample7.entity.Board;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.Entity;
import javax.persistence.Table;

//
public interface BoardRepository extends JpaRepository<Board,Long> {


}
