package com.example.shopping.dto;

import com.example.shopping.entity.GoodsEntity;
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

    public static GoodsDTO toGoodsDTO(GoodsEntity goodsEntity) {
        GoodsDTO goodsDTO = new GoodsDTO();
        goodsDTO.setId(goodsEntity.getId());
        goodsDTO.setGoodsCategory(goodsEntity.getGoodsCategory());
        goodsDTO.setGoodsName(goodsEntity.getGoodsName());
        goodsDTO.setGoodsCost(goodsEntity.getGoodsCost());
        goodsDTO.setGoodsState(goodsEntity.getGoodsState());
        goodsDTO.setGoodsMemo(goodsEntity.getGoodsMemo());
        goodsDTO.setGoodsCreatedTime(goodsEntity.getCreatedTime());
        goodsDTO.setGoodsUpdateTime(goodsEntity.getUpdatedTime());
        if (goodsEntity.getFileAttached() == 0) {
            goodsDTO.setFileAttached(goodsEntity.getFileAttached());
        } else {
            goodsDTO.setFileAttached(goodsEntity.getFileAttached());
            goodsDTO.setOriginalFileName(goodsEntity.getGoodsFileEntityList().get(0).getOriginalFilename());
            goodsDTO.setStoredFileName(goodsEntity.getGoodsFileEntityList().get(0).getStoredFilename());

        }
        return goodsDTO;
    }
}

