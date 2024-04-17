package com.example.shopping.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="goods_file")
public class GoodsFileEntity extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String originalFilename;
    @Column
    private String storedFilename;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "goods_id")
    private GoodsEntity goodsEntity;

}