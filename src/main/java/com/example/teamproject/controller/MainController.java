
//package com.example.teamproject.controller;
//
//import com.example.teamproject.service.board.BoardReplyServiceImpl;
//import com.example.teamproject.service.product.ProductServieceImpl;
//import com.example.teamproject.service.request.RequestServieceImpl;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//@Controller
//@Slf4j
//@RequestMapping("/")
//@RequiredArgsConstructor
//public class MainController {
//    private final BoardReplyServiceImpl boardReplyService;
//    private final ProductServieceImpl productServiece;
//    private final RequestServieceImpl requestServiece;
//
//    @GetMapping("/")
//    public String goToMain(Model model){
//        log.info("*************");
//        log.info("메인페이지");
//        log.info("*************");
//        // 상품 리스트
//        // 다이어리 리스트
//        return "/main/main";
//    }
//}

package com.example.teamproject.controller;

import com.example.teamproject.service.board.BoardServiceImpl;
import com.example.teamproject.service.product.ProductServieceImpl;
import com.example.teamproject.service.request.RequestServieceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/")
@RequiredArgsConstructor
public class MainController {
    private final BoardServiceImpl boardService;
    private final ProductServieceImpl productServiece;
    private final RequestServieceImpl requestServiece;

    @GetMapping("/")
    public String goToMain(Model model){
        log.info("*************");
        log.info("메인페이지");
        log.info("*************");
        // 상품 리스트
        // 다이어리 리스트
        return "/main/main";
    }
}

