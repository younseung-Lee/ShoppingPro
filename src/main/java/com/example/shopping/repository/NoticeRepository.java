package com.example.shopping.repository;

import com.example.shopping.entity.NoticeEntity;
import com.example.shopping.service.NoticeService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoticeRepository extends JpaRepository<NoticeEntity, Long> {
    @Modifying
    @Query(value = "update NoticeEntity b set b.noticeHit = b.noticeHit + 1 where b.id=:id")
    void updateHit(@Param("id") Long id);

    // 최신글이 상위로 가는 쿼리문
    @Query("SELECT p FROM NoticeEntity p ORDER BY p.id DESC")
    List<NoticeEntity> findAllDesc();

}
