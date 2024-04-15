package com.example.shopping.dto;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class GoodsDTO {
    private Long id;
    private String goodsCategory;
    private String goodsName;
    private String goodsCost;
    private String goodsMemo;
    private String goodsState;
    private LocalDateTime goodsCreatedTime;
    private LocalDateTime goodsUpdateTime;

    private MultipartFile goodsFile;
    private String originalFileName;
    private String storedFileName;
    private int fileAttached; //파일첨부
}
