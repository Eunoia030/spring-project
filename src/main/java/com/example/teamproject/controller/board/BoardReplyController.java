package com.example.teamproject.controller.board;

import com.example.teamproject.domain.vo.BoardReplyVO;
import com.example.teamproject.service.board.BoardReplyServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Optional;

@RestController
@Slf4j
@RequestMapping("/boardReply/*")
@RequiredArgsConstructor
public class BoardReplyController {
    private final BoardReplyServiceImpl boardReplyService;

    // 다이어리 댓글 등록
    @PostMapping(value = "/new", consumes = "application/json", produces = "text/plain; charset=utf-8")
    public ResponseEntity<String> create(@RequestBody BoardReplyVO boardReplyVO) throws UnsupportedEncodingException {
        log.info("boardReplyVO : " + boardReplyVO);
        boardReplyService.register(boardReplyVO);
        return new ResponseEntity<>(new String("댓글 등록 성공".getBytes(), "UTF-8") , HttpStatus.OK);
    }

    // 다이어리 댓글 1개 조회
    @GetMapping("/{rno}")
    public BoardReplyVO read(@PathVariable("rno") Long rno){
        log.info("read........ : " + rno);
        return boardReplyService.read(rno);
    }

    // 다이어리 댓글 전체 목록 조회
//    @GetMapping("/list/{bno}/{page}")
//    public ReplyPageDTO getList(@PathVariable("page") int pageNum, @PathVariable("bno") Long bno){
//        return new ReplyPageDTO(boardReplyService.getList(new Criteria(pageNum, 10), bno), boardReplyService.getTotal(bno));
//    }

    // 다이어리 댓글 삭제
    @DeleteMapping("/{rno}")
    public String remove(@PathVariable("rno") Long rno){
        boardReplyService.remove(rno);
        return "댓글 삭제 성공";
    }

    // 다이어리 댓글 수정
    @PatchMapping(value = {"/{rno}/{writer}", "/{rno}"}, consumes = "application/json")
    public String modify(@PathVariable("rno") Long replyNumber, @PathVariable(value = "writer", required = false) String replyWriter, @RequestBody BoardReplyVO boardReplyVO){
        log.info("modify......... : " + boardReplyVO);
        log.info("modify......... : " + replyNumber);

        if(boardReplyVO.getName() == null){ // JSON 검증
            boardReplyVO.setName(Optional.ofNullable(replyWriter).orElse("anonymous")); // URI 검증
        }
        boardReplyVO.setRno(replyNumber);
        boardReplyService.modify(boardReplyVO);
        return "댓글 수정 성공";
    }

}
