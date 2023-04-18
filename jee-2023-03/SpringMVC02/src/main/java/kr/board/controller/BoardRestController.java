package kr.board.controller;

import kr.board.entity.Board;
import kr.board.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/board")
@RestController //ajax통신을 할 때 사용하는 컨트롤러이며 @ResponseBody를 생략이며 json으로 응답하는것이다.
public class BoardRestController {

    @Autowired
    BoardMapper boardMapper;


    @GetMapping("/all")
    public  List<Board> boardList() {
        List<Board> list = boardMapper.getLists();
        return list;
    }

//    @RequestMapping("/boardInsert.do")
    @PostMapping("/new")
    public  void boardInsert(Board vo) {
        boardMapper.boardInsert(vo);
    }

    @DeleteMapping("/{idx}")
    public void boardDelete(@PathVariable("idx") int idx) {
        boardMapper.boardDelete(idx);
    }
    @PutMapping("/update")
    public void boardUpdate(@RequestBody  Board vo) {
        boardMapper.boardUpdate(vo);
    }

    @GetMapping("/{idx}")
    public Board boardContent(@PathVariable("idx") int idx) {
        Board vo = boardMapper.boardContent(idx);
//       System.out.println("2023-04-18 17:51:48.216  INFO 39958 --- [  restartedMain] k.b.controller.SpringMvc101Application   : 상세보기");
        return vo;
    }

    @PutMapping("/count/{idx}")
    public Board boardCount(@PathVariable("idx") int idx) {
        boardMapper.boardCount(idx);
        Board vo = boardMapper.boardContent(idx);
        return vo;
    }


}
