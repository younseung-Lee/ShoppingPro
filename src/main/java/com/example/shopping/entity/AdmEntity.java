package com.example.shopping.entity;

import com.example.shopping.dto.AdmDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

//Entity에서 테이블을 만듬
@Entity
@Setter
@Getter
@Table(name = "admin") //관리자 데이터를 담을 테이블
public class AdmEntity {
    @Id //pk지정
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto increasement : ID컬럼을 1씩 자동증감 시켜줌
    private Long id;

    @Column()
    private String admId;

    @Column()
    private String admPass;

    @Column()
    private String admName;

    public static AdmEntity toAdmEntity(AdmDTO admDTO){
        AdmEntity admEntity = new AdmEntity();
        admEntity.setAdmId(admDTO.getAdmId());
        admEntity.setAdmPass(admDTO.getAdmPass());
        admEntity.setAdmName(admDTO.getAdmName());
        return admEntity;
    }

}
