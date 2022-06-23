package com.example.teamproject.controller.board;

import com.example.teamproject.domain.vo.BoardVO;
import com.example.teamproject.domain.vo.Criteria;
import com.example.teamproject.domain.vo.RequestVO;
import com.example.teamproject.service.board.BoardServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@Slf4j
@RequestMapping("/board/*")
@RequiredArgsConstructor
public class BoardController {
    private final BoardServiceImpl boardService;
    // 다이어리

    @GetMapping("/register")
    public String register(){
        log.info("*************");
        log.info("다이어리 작성");
        log.info("*************");
        return "/diary/board_write";
    }
//    @PostMapping("/register")
//    public String register(BoardVO boardVO, RedirectAttributes rttr){
//        log.info("*************");
//        log.info("다이어리 등록");
//        log.info("*************");
//        // 다이어리 등록
//        return new RedirectView("/board/list");
//    }

    @GetMapping("/modify")
    public String modify(Long bno){
        log.info("*************");
        log.info("다이어리 수정내용 작성/삭제");
        log.info("*************");
        // 다이어리 수정
        return "/diary/modify";
    }
//    @PostMapping("/modify")
//    public String modify(Long bno, RedirectAttributes rttr){
//        log.info("*************");
//        log.info("다이어리 수정");
//        log.info("*************");
//        // 다이어리 수정 완료
//        return new RedirectView("/board/list");
//    }
//    @PostMapping("/remove")
//    public String remove(Long bno, RedirectAttributes rttr){
//        log.info("*************");
//        log.info("다이어리 삭제");
//        log.info("*************");
//        // 다이어리 삭제
//        return new RedirectView("/board/list");
//    }

    @GetMapping("/detail")
    public String read(Long bno, Model model){
        log.info("*************");
        log.info("다이어리 상세");
        log.info("*************");
        // 다이어리 상세
        return "/diary/detail";
    }

    @GetMapping("/list")
    public String getList(Criteria criteria, Model model){
        log.info("*************");
        log.info("다이어리 리스트");
        log.info("*************");
        // 다이어리 리스트
        return "/diary/index";
    }

    ///////////////////////////////////////////////////
    // ResponsBody

    // 상품사진 업로드(상품요청글 작성페이지)
    @PostMapping("/uploadImg")
    @ResponseBody
    public void uploadImg(MultipartFile[] uploadFile) throws IOException {
        String uploadFolder = "C:/upload";
        for(MultipartFile file : uploadFile){
            log.info("--------------------------------");
            log.info("Upload File Name : " + file.getOriginalFilename());
            log.info("Upload File Size : " + file.getSize());

            File saveFile = new File(uploadFolder, file.getOriginalFilename());
            file.transferTo(saveFile);
        }
    }

    // 카테고리별 상품 목록
    @GetMapping("/list/{bcate}") // #카테고리 변수명 미정
    @ResponseBody
    public List<RequestVO> getList(@PathVariable("bcate")String bcate){
        return null;
    }

    // 무한 스크롤
    @GetMapping("/list/{bcate}/{pageNum}")
    @ResponseBody
    public List<RequestVO> getMoreList(@PathVariable("bcate") String bcate, @PathVariable("pageNum") int pageNum){
        return null;
    }

    // 좋아요 목록에 추가
    @GetMapping("/wish")
    @ResponseBody
    public boolean wish(Long bno){
        return false;
    }
}
