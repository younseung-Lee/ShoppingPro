package com.example.shopping.service;

import com.example.shopping.dto.NoticeDTO;
import com.example.shopping.entity.NoticeEntity;
import com.example.shopping.repository.NoticeRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor //Repository의 상속자를 주입받기 위해 사용하는 어노테이션
public class NoticeService {
    private final NoticeRepository noticeRepository;
    public void save(NoticeDTO noticeDTO){

        NoticeEntity noticeEntity = NoticeEntity.toSaveEntity(noticeDTO);
        noticeRepository.save(noticeEntity);
    }

    //페이지에서 리스트 형태로 보여주기 위해 Repository에서 모든 Entity의 데이터를 검색하여 DTO로 다시 변경해주어야 한다.
    public List<NoticeDTO> findAll() {
        List<NoticeEntity> noticeEntityList = noticeRepository.findAll();
        List<NoticeDTO> noticeDTOList = new ArrayList<>();
        //가져온 DTO를 리스트에 담아서 for문을 통해 리스트에 추가되게 함
        for (NoticeEntity noticeEntity: noticeEntityList){
            noticeDTOList.add(NoticeDTO.toNoticeDTO(noticeEntity));
        }
        return noticeDTOList;
    }
    public NoticeDTO findById(Long id) {
        Optional<NoticeEntity> optionalNoticeEntity = noticeRepository.findById(id);
        if (optionalNoticeEntity.isPresent()){
            NoticeEntity noticeEntity = optionalNoticeEntity.get();
            NoticeDTO noticeDTO = NoticeDTO.toNoticeDTO(noticeEntity);
            return noticeDTO;
        } else {
            return null;
        }
    }
    @Transactional
    public void updateHits(Long id) {
        noticeRepository.updateHit(id);
    }
}
