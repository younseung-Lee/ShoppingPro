package com.example.shopping.dto;

import com.example.shopping.entity.NoticeEntity;
import lombok.*;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
//관리자모드 공지사항 등록 데이터그릇
public class NoticeDTO {
    private Long id; //일련번호
    private String noticeTitle; //제목
    private String noticeName; //이름
    private String noticeContent; //내용
    private int noticeHit; //조회수
    private LocalDateTime noticeCreatedTime; //작성 시간
    private LocalDateTime noticeUpdatedTime; //수정 시간

    //noticeEntity를 noticeDTO로 변환하는 코드인 toNoticeDTO
    public static NoticeDTO toNoticeDTO(NoticeEntity noticeEntity){
        NoticeDTO noticeDTO = new NoticeDTO();
        noticeDTO.setId(noticeEntity.getId());
        noticeDTO.setNoticeTitle((noticeEntity.getNoticeTitle()));
        noticeDTO.setNoticeContent(noticeEntity.getNoticeContent());
        noticeDTO.setNoticeName(noticeEntity.getNoticeName());
        noticeDTO.setNoticeHit(noticeEntity.getNoticeHit());
        noticeDTO.setNoticeCreatedTime(noticeEntity.getCreatedTime());
        noticeDTO.setNoticeUpdatedTime(noticeEntity.getUpdatedTime());
        return noticeDTO;
    }
}
