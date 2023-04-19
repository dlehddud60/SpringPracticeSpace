package kr.board.controller;

import kr.board.entity.Member;
import kr.board.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
public class MemberController {


    @Autowired
    MemberMapper memberMapper;

    @RequestMapping("/memJoin.do")
    public String memJoin() {
        return "member/join";
    }

    @RequestMapping("/memRegisterCheck.do")
    public @ResponseBody int memRegisterCheck(@RequestParam("memID") String memID) {
        Member m = memberMapper.registerCheck(memID);
        if (m != null || memID.equals("")) {
            System.out.println("2023-04-19 16:17:26.964  INFO 37618 --- [nio-8080-exec-1] o.s.web.servlet.DispatcherServlet        : 사용불가능한 아이디");

            return 0; //이미 존재하는 회원, 입력불가
        }
        System.out.println("2023-04-19 16:17:26.964  INFO 37618 --- [nio-8080-exec-1] o.s.web.servlet.DispatcherServlet        : 사용가능한 아이디");
        return 1; //사용가능한 아이디
    }

//    회원가입 처리
    @RequestMapping("/memRegister.do")
    public String memRegister(Member m, String memPassword1, String memPassword2,
                              RedirectAttributes rttr, HttpSession session) {
        if(m.getMemID() == null || m.getMemID().equals("")||
           memPassword1 == null || memPassword1.equals("")||
           memPassword2 == null || memPassword2.equals("")||
           m.getMemName() == null || m.getMemName().equals("")||
           m.getMemAge() == 0 ||
           m.getMemGender() == null || m.getMemGender().equals("")||
           m.getMemEmail() == null || m.getMemEmail().equals("")) {
            //누락메시지를 가지고 가기? => 객체 바인딩은 jsp로 갈 때 가능하다.

            rttr.addFlashAttribute("msgType","실패 메세지");
            rttr.addFlashAttribute("msg","모든 내용을 입력하세요 ");
            return "redirect:/memJoin.do";
        }

        if(!memPassword1.equals(memPassword2)) {
            rttr.addFlashAttribute("msgType","실패 메세지");
            rttr.addFlashAttribute("msg","비밀번호가 서로 다릅니다.");
            return "redirect:/memJoin.do";
        }

        m.setMemProfile("");//사진 이미지는 없다는 의미로 ""
        //회원을 테이블에 저장하기
        int result = memberMapper.register(m);
        if (result == 1) {//회원가입 성공 메시지
            rttr.addFlashAttribute("msgType","회원가입 성공메시지");
            rttr.addFlashAttribute("msg","회원가입에 성공했습니다.");
            //회원가입이 성공하면-> 로그인처리하기
            session.setAttribute("mvo",m); //${empty m}
            return "redirect:/";
        } else {
            rttr.addFlashAttribute("msgType","실패 메시지");
            rttr.addFlashAttribute("msg","이미 존재하는 회원입니다.");
            return "redirect:/memJoin.do";
        }
    }

    //로그아웃 처리
    @RequestMapping("/memLogout.do")
    public String memLogout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
    //로그인 화면으로 이동
    @RequestMapping("/memLoginForm.do")
    public String memLoginForm() {
        return "member/memLoginForm";
    }
//    로그인 기능 구현
    @RequestMapping("/memLogin.do")
    public String memLogin(Member m, RedirectAttributes rttr, HttpSession session) {
        if (m.getMemID() == null || m.getMemID().equals("")||
            m.getMemPassword() == null || m.getMemPassword().equals("")) {

            rttr.addFlashAttribute("msgType","실패 메세지");
            rttr.addFlashAttribute("msg","모든 내용을 입력해주세요");
            return "redirect:/memLoginForm.do";
        }
        Member mvo = memberMapper.memLogin(m);
        if(mvo != null) { //로그인 성공
            rttr.addFlashAttribute("msgType","성공 메세지");
            rttr.addFlashAttribute("msg","로그인에 성공했습니다.");
            session.setAttribute("mvo",mvo); // ${empty mvo} 헤더에서 체크하고 있음
            return "redirect:/";
        }else{ //로그인 실패
            rttr.addFlashAttribute("msgType","실패 메세지");
            rttr.addFlashAttribute("msg","로그인에 실패했습니다.");
            return "redirect:/memLoginForm.do";

        }
    }



}
