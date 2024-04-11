package com.example.shopping.service;

import com.example.shopping.dto.AdmDTO;
import com.example.shopping.entity.AdmEntity;
import com.example.shopping.repository.AdmRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AdmService {
    private final AdmRepository admRepository;
    public void save(AdmDTO admDTO) {
        // dto를 entity로 변환을 시켜야함
        AdmEntity admEntity = AdmEntity.toAdmEntity(admDTO);
        admRepository.save(admEntity);
    }

    public AdmDTO login(AdmDTO admDTO) {
        // 입력된 아이디를 db에서 조회 --> db비번과 입력된 비번 일치
        Optional<AdmEntity> byAdmId =  admRepository.findByAdmId(admDTO.getAdmId());
            if (byAdmId.isPresent()){
                // 조회된 결과가 있다면 가져오기
                AdmEntity admEntity = byAdmId.get();
                if(admEntity.getAdmPass().equals(admDTO.getAdmPass())){
                    // 비밀번호가 일치하면
                    //entity -> dto 변환
                    AdmDTO dto = AdmDTO.toAdmDTO(admEntity);
                    return dto;
                } else {
                    //비밀번호 불일치
                }
            } else {
                // 조회결과가 없다면
                return null;
            }
        return null;
    }
}
