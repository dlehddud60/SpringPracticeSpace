package com.test1.boardTest.controller;

import com.test1.boardTest.entity.Board;
import com.test1.boardTest.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class BoardController {

    private BoardRepository boardRepository;
    @Autowired
    public BoardController(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    @GetMapping("/")
    public String list(Model model){
//        model.addAttribute("list",boardRepository.findAll());
        model.addAttribute("list",boardRepository.findAllByOrderByNoDesc());

        return "list";
    }

    @GetMapping("/write")
    public String write(){
        return "write";
    }

    @PostMapping("/write")
    public String write(@ModelAttribute Board board) {
        Board result = boardRepository.save(board);
//        return "redirect:/";
        return "redirect:detail?no=" + result.getNo();
    }
    @GetMapping("/detail")
    public String detail(@RequestParam long no, Model model){
        Board board = boardRepository.findById(no).orElseThrow();

        board.setReadcount(board.getReadcount()+1);
        Board result = boardRepository.save(board);
        model.addAttribute("board",result);
        return "detail";
    }
    @GetMapping("/edit")
    public String edit(@RequestParam long no, Model model){
        Board board = boardRepository.findById(no).orElseThrow();
        model.addAttribute("board",board);
        return "edit";
    }
    @PostMapping("/edit")
    public String edit(@ModelAttribute Board board, RedirectAttributes attr) {
        Board origin = boardRepository.findById(board.getNo()).orElseThrow();
        origin.setTitle(board.getTitle());
        origin.setWriter(board.getWriter());
        origin.setContent(board.getContent());
        Board result = boardRepository.save(origin);
        attr.addAttribute("no",result.getNo());
        return "redirect:detail";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam long no) {
        boardRepository.deleteById(no);
        return "redirect:/";
    }
}
