package com.example.teamproject.controller.product;

import com.example.teamproject.domain.vo.ProductVO;
import com.example.teamproject.service.product.ProductServieceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
@Slf4j
@RequestMapping("/product/*")
@RequiredArgsConstructor
public class ProductController {
    private final ProductServieceImpl productService;
    // 상품

    @GetMapping("/register")
    public String register(){
        log.info("*************");
        log.info("판매 상품정보 작성");
        log.info("*************");
        return "/product/product";
    }
//    @PostMapping("/register")
//    public String register(ProductVO productVO, RedirectAttributes rttr){
//        log.info("*************");
//        log.info("판매 상품 등록");
//        log.info("*************");
//        // 판매 상품 등록
//        return new RedirectView("/product/list");
//    }

    @GetMapping("/list")
    public String getList(Model model){
        log.info("*************");
        log.info("상품 리스트");
        log.info("*************");
        // 상품 리스트
        return "/product/sell_list";
    }

    @GetMapping("/detail")
    public String read(Long pno, Model model){
        log.info("*************");
        log.info("상품 상세");
        log.info("*************");
        // 상품 상세
        return "/product/detail";
    }

    @GetMapping("/modify")
    public String modify(Long pno){
        log.info("*************");
        log.info("상품 수정");
        log.info("*************");
        // 상품 수정
        return "/product/modify";
    }
//    @PostMapping("/modify")
//    public String modify(Long pno, RedirectAttributes rttr){
//        log.info("*************");
//        log.info("상품 수정 완료");
//        log.info("*************");
//        // 다이어리 수정 완료
//        return new RedirectView("/product/list");
//    }

    ///////////////////////////////////////////////////
    // ResponsBody

    // 카테고리별 상품 목록
    @GetMapping("/list/{pcate}") // 변수명 미정
    @ResponseBody
    public List<ProductVO> getList(@PathVariable("pcate") String pcate){
        return null;
    }

    // 무한 스크롤
    @GetMapping("/list/{pcate}/{pageNum}") // 변수명 미정
    @ResponseBody
    public List<ProductVO> getList(@PathVariable("pcate") String pcate, @PathVariable("pageNum") int pageNum){
        return null;
    }
}
