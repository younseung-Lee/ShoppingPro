package com.example.shopping.service;

import com.example.shopping.dto.GoodsDTO;
import com.example.shopping.dto.NoticeDTO;
import com.example.shopping.entity.GoodsEntity;
import com.example.shopping.entity.GoodsFileEntity;
import com.example.shopping.entity.NoticeEntity;
import com.example.shopping.repository.GoodsFileRepository;
import com.example.shopping.repository.GoodsRepository;
import jakarta.persistence.Id;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GoodsService {
    private final GoodsRepository goodsRepository;
    private final GoodsFileRepository goodsFileRepository;

    public GoodsDTO findById(Long id) {
        Optional<GoodsEntity> optionalGoodsEntity = goodsRepository.findById(id);
        if (optionalGoodsEntity.isPresent()){
            GoodsEntity goodsEntity = optionalGoodsEntity.get();
            GoodsDTO goodsDTO = GoodsDTO.toGoodsDTO(goodsEntity);
            return goodsDTO;
        } else {
            return null;
        }
    }

    public void save(GoodsDTO goodsDTO) throws IOException {
        if (goodsDTO.getGoodsFile().isEmpty()) { //첨부파일이 없다면
            GoodsEntity goodsEntity = GoodsEntity.toSaveEntity(goodsDTO);
            goodsRepository.save(goodsEntity);
        } else {
            //첨부파일이 있다면
            MultipartFile goodsFile = goodsDTO.getGoodsFile(); // DTO에 담긴 파일
            String originalFileName =  goodsFile.getOriginalFilename();
            //파일의 원본이름을 가져옴
            String storedFilename = System.currentTimeMillis() + "_" + originalFileName;
            //새로운 파일이름을 생성한다. 숫자값_파일명
            String savePath = "C:/shop_img/" + storedFilename;
            //해당 디렉토리에 저장
            goodsFile.transferTo(new File(savePath));
            GoodsEntity goodsEntity = GoodsEntity.toSaveFileEntity(goodsDTO);
            Long saveId = goodsRepository.save(goodsEntity).getId();
            GoodsEntity goods = goodsRepository.findById(saveId).get();
            GoodsFileEntity goodsFileEntity = GoodsEntity.toGoodsFileEntity(goods,
                    originalFileName, storedFilename);
            goodsFileRepository.save(goodsFileEntity);
        }
    }
    @Transactional
    public List<GoodsDTO> findAll() {
        List<GoodsEntity> goodsEntityList = goodsRepository.findAll();
        List<GoodsDTO> goodsDTOList = new ArrayList<>();

       for (GoodsEntity goodsEntity: goodsEntityList){
           goodsDTOList.add(GoodsDTO.toGoodsDTO(goodsEntity));
        }
        return goodsDTOList;


    }
}

