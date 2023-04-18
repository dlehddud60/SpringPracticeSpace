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

    @Autowired
    BoardMapper boardMapper;

    @RequestMapping("/")
   public String main()   {
       return "main";
   }

   @RequestMapping("/boardList.do")
    public @ResponseBody List<Board> boardList() {
       List<Board> list = boardMapper.getLists();
       return list;
   }

   @RequestMapping("/boardInsert.do")
    public @ResponseBody void boardInsert(Board vo) {
        boardMapper.boardInsert(vo);
   }

   @RequestMapping("boardDelete.do")
    public @ResponseBody void boardDelete(@RequestParam("idx") int idx) {
        boardMapper.boardDelete(idx);
   }
   @RequestMapping("/boardUpdate.do")
    public @ResponseBody void boardUpdate(Board vo) {
        boardMapper.boardUpdate(vo);
   }

   @RequestMapping("/boardContent.do")
    public @ResponseBody Board boardContent(int idx) {
       Board vo = boardMapper.boardContent(idx);
//       System.out.println("2023-04-18 17:51:48.216  INFO 39958 --- [  restartedMain] k.b.controller.SpringMvc101Application   : 상세보기");
       return vo;
   }

   @RequestMapping("/boardCount.do")
    public @ResponseBody Board boardCount(int idx) {
        boardMapper.boardCount(idx);
       Board vo = boardMapper.boardContent(idx);
       return vo;
   }

}