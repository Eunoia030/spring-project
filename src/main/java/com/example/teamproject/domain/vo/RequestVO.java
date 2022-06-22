package com.example.teamproject.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
@Data
public class RequestVO {
    private Long rno;
    private String name;
    private String title;
    private String content;
    private String registerDate;
    private String updateDate;

    private List<FileVO> fileList;
}
