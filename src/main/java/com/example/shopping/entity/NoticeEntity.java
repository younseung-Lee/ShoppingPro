package com.example.shopping.entity;

import com.example.shopping.dto.NoticeDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "notice")
public class NoticeEntity extends BaseEntity{ //BaseEntity의 등록시간, 수정시간 컬럼을 extends를 통해 받아옴
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50, nullable = false)
    private String noticeTitle;

    @Column(length = 20, nullable = false)
    private String noticeName;

    @Column(length = 500)
    private String noticeContent;

    @Column
    private int noticeHit;

    public static NoticeEntity toSaveEntity(NoticeDTO noticeDTO){
        NoticeEntity noticeEntity = new NoticeEntity();
        noticeEntity.setNoticeTitle(noticeDTO.getNoticeTitle());
        noticeEntity.setNoticeName(noticeDTO.getNoticeName());
        noticeEntity.setNoticeContent(noticeDTO.getNoticeContent());
        noticeEntity.setNoticeHit(0);
        return noticeEntity;
    }

}
