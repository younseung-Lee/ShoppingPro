package com.example.shopping.repository;

import com.example.shopping.entity.GoodsEntity;
import com.example.shopping.entity.GoodsFileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GoodsFileRepository extends JpaRepository<GoodsFileEntity, Long> {
}
