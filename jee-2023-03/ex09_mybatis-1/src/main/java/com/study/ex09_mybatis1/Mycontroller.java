package com.study.ex09_mybatis1;

import com.study.ex09_mybatis1.dao.IBoardDao;
import com.study.ex09_mybatis1.dto.BoardDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class Mycontroller {

    @Autowired
    IBoardDao boardDao;

    @RequestMapping("/")
//    @ResponseBody
    public String root() {
//        return "root()함수 호출됨."; //문자열로 반환
        System.out.println("listForm으로 리다이렉트 됨.");
        return "redirect:listForm";
    }

    @RequestMapping("/listForm")
    public String listForm(Model model) {
        List<BoardDto> list = boardDao.list();
        model.addAttribute("list",list);
        System.out.println("list" + list);
        return "listForm";
    }
    @RequestMapping("/writeForm")
    public String writeForm() {
        return "writeForm"; //writeForm.jsp를 디스패치 기
    }

    @RequestMapping("/writeAction")
    public String writeForm(@RequestParam("board_name") String board_name,
                            @RequestParam("board_title") String board_title,
                            @RequestParam("board_content") String board_content) {
        int result = boardDao.write(board_name, board_title, board_content);
        if(result == 1) {
            System.out.println("글쓰기 성공!");
        }else {
            System.out.println("글쓰기 실패! ");
        }


        return "redirect:listForm";

    }


}
