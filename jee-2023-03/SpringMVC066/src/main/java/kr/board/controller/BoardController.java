package kr.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class BoardController {

    @RequestMapping("/boardMain.do")
   public String main()   {
       return "board/main";
   }



}