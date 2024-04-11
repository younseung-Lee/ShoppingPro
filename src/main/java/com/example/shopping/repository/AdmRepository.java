package com.example.shopping.repository;

import com.example.shopping.entity.AdmEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdmRepository extends JpaRepository<AdmEntity, Long> {

}
