package com.example.shopping.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "admin")
public class AdmEntity {
    @Id // PK 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY) //자동증가
    private Long id;

    @Column()
    private String admId;

    @Column()
    private String admPass;

    @Column()
    private String admName;
}
