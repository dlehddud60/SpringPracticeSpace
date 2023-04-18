package kr.board.controller;

import kr.board.entity.Board;
import kr.board.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BoardController {

    @RequestMapping("/")
   public String main()   {
       return "main";
   }



}