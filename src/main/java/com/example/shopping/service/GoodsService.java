package com.example.shopping.service;

import com.example.shopping.dto.GoodsDTO;
import com.example.shopping.entity.GoodsEntity;
import com.example.shopping.repository.GoodsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Service
@RequiredArgsConstructor
public class GoodsService {
    private final GoodsRepository goodsRepository;

    public void save(GoodsDTO goodsDTO) {
        if (goodsDTO.getGoodsFile().isEmpty()) { //첨부파일이 없다면
            GoodsEntity goodsEntity = GoodsEntity.toSaveEntity(goodsDTO);
            goodsRepository.save(goodsEntity);
        } else {
            //첨부파일이 있다면
            MultipartFile goodsFile = goodsDTO.getGoodsFile(); // DTO에 담긴 파일
            String originalFileName =  goodsDTO.getOriginalFileName();
            //파일의 원본이름을 가져옴
            String storedFilename = System.currentTimeMillis() + "_" + originalFileName;
            //새로운 파일이름을 생성한다. 숫자값_파일명
            String savePath = "C:/shop_img" + storedFilename;
            //해당 디렉토리에 저장
            goodsFile.transferTo(new File(savePath));
        }
    }
}
