
package com.example.teamproject.controller.user;

import com.example.teamproject.domain.vo.UserVO;
import com.example.teamproject.service.user.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;

@Controller
@Slf4j
@RequestMapping("/user/*")
@RequiredArgsConstructor
public class UserController {
    private final UserServiceImpl userService;
    // 회원가입/로그인/비밀번호찾기/마이페이지

    @GetMapping("/join")
    public String goToJoin(){
        log.info("*************");
        log.info("회원가입");
        log.info("*************");
        return "/user/join";
    }
    @PostMapping("/join")
    public String join(UserVO userVO){
        log.info("*************");
        log.info("회원등록");
        log.info("*************");
        // 회원등록
        userService.register(userVO);
        return "/user/login";
    }

    @GetMapping("/login")
    public String goToLogin(){
        log.info("*************");
        log.info("로그인");
        log.info("*************");
        return "/user/login";
    }
    @PostMapping("/login")
    public String login(String email, String pw, HttpSession session){
        log.info("*************");
        log.info("로그인 시도");
        log.info("*************");
        log.info(userService.login(email).getPw());
        if(pw.equals(userService.login(email).getPw())){
            log.info("xxx");
            // 로그인 성공
            session.setAttribute("email", email);
            session.setAttribute("name", userService.login(email).getName());
            return "/user/mypage";
        }
        // 로그인 실패
        return "/user/login";
    }

    @GetMapping("/find_pw")
    public String goToFindPw(){
        log.info("*************");
        log.info("비밀번호찾기");
        log.info("*************");
        return "/user/find_pw";
    }

    @GetMapping("/modify")
    public String modify(Model model){
        log.info("*************");
        log.info("회원정보수정");
        log.info("*************");
        return "/user/update";
    }
//    @PostMapping("/modify")
//    public String modify(RedirectAttributes rttr){
//        log.info("*************");
//        log.info("회원정보수정");
//        log.info("*************");
//        return new RedirectView("/user/mypage");
//    }

    // 마이페이지

    @GetMapping("/mypage")
    public String goToMypage(Model model){
        log.info("*************");
        log.info("마이페이지");
        log.info("*************");
        // 개인정보
        // 좋아요한 다이어리 목록
        // 내가 쓴 다이어리 목록
        // 내가 올린 상품 목록
        return "/user/mypage";
    }

    ///////////////////////////////////////////////////
    // ResponsBody

    // 이메일 중복확인
    @PostMapping("/checkEmail")
    @ResponseBody
    public int checkEmail(String email){
        return 0;
    }

    // 이름 중복확인
    @PostMapping("/checkId")
    @ResponseBody
    public boolean checkName(@RequestBody String name){
        log.info(name);
        if(userService.checkName(name) <= 0){
            return true;
        }
        return false;
    }

    // 이름 수정
}
