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
    private BoardMapper mapper;


    @RequestMapping("/boardList.do")
    public String boardList(Model model) {

        List<Board> list = mapper.getLists();
        model.addAttribute("list",list);
        return "boardList"; // /WEB_INF/views/boardList.jsp라는 경로가 만들어지는데 이 역활을 하는 클래스를 뷰리졸버라고 한다.
//        이 뷰리졸버도 스프링에서 제공이 된다.
    }

    @GetMapping("/boardForm.do")
    public String boardForm() {
        return "boardForm";
    }

    @PostMapping("/boardInsert.do")
    public String boardInsert(Board vo) { // title, content, writer => 파라메터 수집
        mapper.boardInsert(vo); //등록
        return "redirect:/boardList.do";
    }

    @GetMapping("/boardContent.do")
    public String boardContent(@RequestParam("idx") int idx, Model model) {
        Board vo = mapper.boardContent(idx);
        //조회수 증가
        mapper.boardCount(idx);


        model.addAttribute("vo",vo);
        return "boardContent";
    }

    @GetMapping("/boardDelete.do/{idx}")
    public String boardDelete(@PathVariable("idx") int idx) {
        mapper.boardDelete(idx);

        return "redirect:/boardList.do";
    }

    @GetMapping("/boardUpdateForm.do/{idx}")
    public String boardUpdateForm(@PathVariable("idx") int idx,Model model) {
        Board vo = mapper.boardContent(idx);
        model.addAttribute("vo",vo);
        return "boardUpdate";//boardUpdate.jsp
    }
    @PostMapping("/boardUpdate.do")
    public String  boardUpdate(Board vo) {

        mapper.boardUpdate(vo); //수정
        System.out.println("수정완료");

        return "redirect:/boardList.do";

    }

}