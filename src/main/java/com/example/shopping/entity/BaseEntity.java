package com.example.shopping.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

//등록시간, 수정시간을 위한 엔티티는 따로 보관하는편
@EntityListeners(AuditingEntityListener.class)
@Getter
@MappedSuperclass
public class BaseEntity {
    @CreationTimestamp
    @Column(updatable = false) //등록시간이기 떄문에 업데이트에서는 관여x
    private LocalDateTime createdTime; //등록시간

    @UpdateTimestamp
    @Column(insertable = false) //수정시간(update)이기 때문에 등록에는 관여x
    private LocalDateTime updatedTime; //수정시간
}
