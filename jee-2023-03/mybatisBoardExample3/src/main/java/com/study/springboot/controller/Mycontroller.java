package com.study.springboot.controller;

import com.study.springboot.dao.IBoardDao;
import com.study.springboot.dao.IReplyDao;
import com.study.springboot.dto.BoardDto;
import com.study.springboot.dto.ReplyDto;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Log4j2
@Controller
public class Mycontroller {

    private IBoardDao boardDao;
    private IReplyDao replyDao;

    @Autowired
    public Mycontroller(IBoardDao boardDao, IReplyDao replyDao) {
        this.boardDao = boardDao;
        this.replyDao = replyDao;
    }

    @GetMapping("/")
    public String root(){
        return "redirect:list";
    }

    @GetMapping("/list")
    public String list(Model model) {
        List<BoardDto> list = boardDao.list();
        model.addAttribute("list",list);
        return "list";
    }

    @GetMapping("/write")
    public String wirte() {
        return "write";
    }

    @ResponseBody
    @PostMapping("/writeAction")
    public String write(@RequestParam("board_name") String board_name,
                        @RequestParam("board_title") String board_title,
                        @RequestParam("board_content") String board_content,
                        HttpServletRequest request){
        int result = boardDao.write(board_name, board_title, board_content);
        log.info("----------------글쓰기 성공-------------------");
        return "<script>alert('글쓰기 성공!') ; location.href='/list';</script>";
    }

    @GetMapping("/content")
    public String content(@RequestParam String board_idx,
                          Model model,
                          HttpServletRequest request) {
        //조회수 증가
        boardDao.hit(board_idx);

        //게시글 조회
        BoardDto dto = boardDao.viewDto(board_idx);
        model.addAttribute("dto",dto);

        //댓글 리스트 가져오기
        List<ReplyDto> reply_list = replyDao.reply_list(board_idx);
        model.addAttribute("reply_list",reply_list);

        return "content";
    }

    @GetMapping("/updateAction")
    @ResponseBody
    public String updateAction(@RequestParam("board_idx") String board_idx,
                               @RequestParam("board_name") String board_name,
                               @RequestParam("board_title") String board_title,
                               @RequestParam("board_content") String board_content,
                               HttpServletRequest request) {

        int result = boardDao.updateDto(board_idx, board_name, board_title, board_content);
        log.info("-----------------------글수정 성공------------------------------");
        return "<script>alert('글수정 성공!'); location.href='/list';</script>";
    }

    @GetMapping("/deleteAction")
    @ResponseBody
    public String deleteAction(@RequestParam String board_idx,
                               HttpServletRequest request) {
        int result = boardDao.deleteDto(board_idx);
        return "<script>" +
                "alert('글삭제 성공!'); " +
                "location.href='/list';" +
                "</script>";
    }

    @RequestMapping("/writeReplyAction")
    @ResponseBody
    public String writeReplyAction(@RequestParam("reply_content") String reply_content,
                                   @RequestParam("reply_name") String reply_name,
                                   @RequestParam("reply_board_index") String reply_board_index,
                                   HttpServletRequest request)
    {
        int result = replyDao.reply_write(reply_name, reply_content, reply_board_index);

        log.info("--------------------댓글달기 성공!----------------------------");

        return "<script>alert('댓글달기 성공!'); location.href='/content?board_idx=" + reply_board_index + "';</script>";

    }

    @RequestMapping("/deleteReplyAction")
    @ResponseBody
    public String deleteReplyAction(@RequestParam("reply_idx") String reply_idx,
                                    @RequestParam("board_idx") String board_idx,
                                    HttpServletRequest request) {
        int result = replyDao.reply_deleteDto(reply_idx);
        log.info("-------------------------댓글삭제 성공!------------------------------");
        return "<script>alert('댓글삭제 성공!'); location.href='/content?board_idx=" + board_idx + "';</script>";

    }



}
