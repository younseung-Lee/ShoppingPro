package com.example.shopping.repository;

import com.example.shopping.entity.AdmEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository  // 엔티티에 디비를 생성후 repository에 JPA를 통해서 연결시켰다.
public interface AdmRepository extends JpaRepository<AdmEntity, Long> {
    //select * from admin where AdmId=?
    Optional<AdmEntity> findByAdmId(String AdmId);
}
