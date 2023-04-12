package com.study.springboot.controller;

import com.study.springboot.dao.IBoardDao;
import com.study.springboot.dao.IReplyDao;
import com.study.springboot.dto.BoardDto;
import com.study.springboot.dto.ReplyDto;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Log4j2
@Controller
public class Mycontroller {

    IBoardDao boardDao;
    IReplyDao replyDao;

    @Autowired
    public Mycontroller(IBoardDao boardDao, IReplyDao replyDao) {
        this.boardDao = boardDao;
        this.replyDao = replyDao;
    }
    @RequestMapping("/")
//    @ResponseBody
    public String root() {
        log.info("listForm으로 리다이렉트 됨");
        return "redirect:/listForm";
    }


    @RequestMapping("/listForm")
    public String listForm(Model model) {

        List<BoardDto> list = boardDao.list();
        model.addAttribute("list",list);
        log.info(list);
        return "listForm";
    }

    @RequestMapping("/writeForm")
    public String writeForm() {
        return "writeForm"; //writeForm 디스패치함
    }

    @RequestMapping("/writeAction")
    @ResponseBody
    public String writeAction(@RequestParam("board_name") String board_name,
                              @RequestParam("board_title") String board_title,
                              @RequestParam("board_content") String board_content,
                              HttpServletRequest request)
    {
        int result = boardDao.write(board_name,board_title,board_content);
        if (result == 1) {
            log.info("글쓰기 성공");

            return "<script>alert('글쓰기 성공!') ; location.href='/listForm';</script>";
        }else {
            log.info("글쓰기 실패!");

            return "<script>alert('글쓰기 실패!') ; location.href='/writeForm';</script>";
        }
    }

    @RequestMapping("/writeReplyAction")
    @ResponseBody
    public String writeReplyAction(@RequestParam("reply_content") String reply_content,
                                   @RequestParam("reply_name") String reply_name,
                                   @RequestParam("reply_board_index") String reply_board_index,
                                   HttpServletRequest request)
    {
        int result = replyDao.reply_write(reply_name, reply_content, reply_board_index);
        if(result == 1) {
            System.out.println("댓글달기 성공!");

            return "<script>alert('댓글달기 성공!'); location.href='/contentForm?board_idx=" + reply_board_index + "';</script>";
        }else {
            System.out.println("댓글달기 실패!");

            return "<script>alert('댓글달기 실패!'); location.href='/contentForm?board_idx=" + reply_board_index + "';</script>";

        }
    }


    @RequestMapping("/contentForm")
    public String contentForm(@RequestParam("board_idx") String board_idx,
                              Model model,
                              HttpServletRequest request) {
//            조회수증가
        boardDao.hit(board_idx);


        //게시글 보기
        BoardDto dto = boardDao.viewDto( board_idx);
        model.addAttribute("dto",dto);

        //댓글 리스트 가져오기
        List<ReplyDto> reply_list = replyDao.reply_list(board_idx);
        model.addAttribute("reply_list",reply_list);


        return "contentForm";
    }
    @RequestMapping(   "/updateAction")
    @ResponseBody
    public String updateAction(@RequestParam("board_idx") String board_idx,
                               @RequestParam("board_name") String board_name,
                               @RequestParam("board_title") String board_title,
                               @RequestParam("board_content") String board_content,
                               HttpServletRequest request) {

        int result = boardDao.updateDto(board_idx,board_name,board_title,board_content);
        if(result == 1) {
            log.info("글수정 성공!");
            return "<script>alert('글수정 성공!'); location.href='/listForm';</script>";

//            return "redirect:listForm"; //
        }else {
            log.info("글수정 실패! ");
//        return "redirect:updateForm?board_idx" + board_idx; //
            return "<script>alert('글수정 실패!'); location.href='/contentForm?board_idx" + board_idx + "';</script>";

        }
    }

    @RequestMapping("/deleteAction")
    @ResponseBody
    public String deleteAction(@RequestParam("board_idx") String board_idx, HttpServletRequest request) {

        int result = boardDao.deleteDto(board_idx);
        if(result == 1) {
            log.info("글삭제 성공!");

            return "<script>" +
                    "alert('글삭제 성공!'); " +
                    "location.href='/listForm';" +
                    "</script>";


        }else {
            log.info("글삭제 실패 !");
            return "<script>alert('글삭제 실패!'); location.href='/contentForm?board_idx" + board_idx + "';</script>";

        }

    }

    @RequestMapping("/deleteReplyAction")
    @ResponseBody
    public String deleteReplyAction(@RequestParam("reply_idx") String reply_idx,
                                    @RequestParam("board_idx") String board_idx,
                                    HttpServletRequest request) {

        int result = replyDao.reply_deleteDto(reply_idx );
        if(result == 1) {
            log.info("댓글삭제 성공!");

            return "<script>alert('댓글삭제 성공!'); location.href='/contentForm?board_idx=" + board_idx + "';</script>";

        }else {
            log.info("댓글삭제 실패! ");
//        return "redirect:contentForm?board_idx" + board_idx; //
            return "<script>alert('댓글삭제 실패!'); location.href='/contentForm?board_idx=" + board_idx + "';</script>";

        }
    }


}
