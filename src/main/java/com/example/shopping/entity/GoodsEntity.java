package com.example.shopping.entity;

import com.example.shopping.dto.GoodsDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "goods")
public class GoodsEntity extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 50)
    private String goodsCategory;
    @Column()
    private String goodsName;
    @Column(length = 20)
    private String goodsCost;
    @Column(length = 500)
    private String goodsMemo;
    @Column(length = 20)
    private String goodsState;
    @Column
    private int fileAttached;
    @OneToMany(mappedBy = "goodsEntity", cascade = CascadeType.REMOVE,
    orphanRemoval = true, fetch = FetchType.LAZY)
    private List<GoodsFileEntity> goodsFileEntityList = new ArrayList<>();

    public static GoodsEntity toSaveEntity(GoodsDTO goodsDTO){
        GoodsEntity goodsEntity = new GoodsEntity();
        goodsEntity.setGoodsCategory(goodsDTO.getGoodsCategory());
        goodsEntity.setGoodsName(goodsDTO.getGoodsName());
        goodsEntity.setGoodsCost(goodsDTO.getGoodsCost());
        goodsEntity.setGoodsMemo(goodsDTO.getGoodsMemo());
        goodsEntity.setGoodsState(goodsDTO.getGoodsState());
        goodsEntity.setFileAttached(0);
        return goodsEntity;
    }
    public static GoodsEntity toSaveFileEntity(GoodsDTO goodsDTO) {
        GoodsEntity goodsEntity = new GoodsEntity();
        goodsEntity.setGoodsCategory(goodsDTO.getGoodsCategory());
        goodsEntity.setGoodsName(goodsDTO.getGoodsName());
        goodsEntity.setGoodsCost(goodsDTO.getGoodsCost());
        goodsEntity.setGoodsMemo(goodsDTO.getGoodsMemo());
        goodsEntity.setGoodsState(goodsDTO.getGoodsState());
        goodsEntity.setFileAttached(1);
        return goodsEntity;
    }

    public static GoodsFileEntity toGoodsFileEntity(GoodsEntity goodsEntity, String originalFileName, String storedFilename) {

            GoodsFileEntity goodsFileEntity = new GoodsFileEntity();
            goodsFileEntity.setOriginalFilename(originalFileName);
            goodsFileEntity.setStoredFilename(storedFilename);
            goodsFileEntity.setGoodsEntity(goodsEntity);
            return  goodsFileEntity;
        }
    }

//    public static GoodsFileEntity toGoodsFileEntity(GoodsEntity goods, String originalFileName, String storedFilename) {
//    }

