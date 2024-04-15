package com.example.shopping.repository;

import com.example.shopping.entity.AdmEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

//Repository는 class의 interface로 만들고 extends구문 추가하기(<관련엔티티, 데이터타입>)
//엔티티는 테이블의 역할을 함.
//repository의 Jpa를 통해 Entity로 만든 테이블을 연동해줌
public interface AdmRepository extends JpaRepository<AdmEntity, Long> {
    //select * from admin where AdmId=? 를 의미함.
    Optional<AdmEntity> findByAdmId(String AdmId);

}
