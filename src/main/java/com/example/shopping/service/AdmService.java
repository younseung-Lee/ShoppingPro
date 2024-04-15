package com.example.shopping.service;

import com.example.shopping.dto.AdmDTO;
import com.example.shopping.entity.AdmEntity;
import com.example.shopping.repository.AdmRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

//최종적으로 값을 처리하는 패키지 = service
@Service
@RequiredArgsConstructor
public class AdmService {
    //AdmRepository를 불러온다.
    private final AdmRepository admRepository; //데이터베이스와의 연결고리

    //AdmController에서 적어준 save
    public void save(AdmDTO admDTO) {
        //DTO를 Entity로 변환(담아왔던 것을 데이터베이스에 들어갈 수 있는것으로 변환한다는 뜻)
        AdmEntity admEntity = AdmEntity.toAdmEntity(admDTO);
        admRepository.save(admEntity);

    }

    public AdmDTO login(AdmDTO admDTO) {
        //입력된 아이디를 db에서 조회 --> db에 있는 비번과 입력된 비번이 일치하는지 확인
        Optional<AdmEntity> byAdmId = admRepository.findByAdmId(admDTO.getAdmId());
        if (byAdmId.isPresent()){
            //조회된 결과가 있다면
            AdmEntity admEntity = byAdmId.get();
            if(admEntity.getAdmPass().equals(admDTO.getAdmPass())){
                //비밀번호가 일치하면
                //entity --> dto 변환 후에 처리해야함
                AdmDTO dto = AdmDTO.toAdmDTO(admEntity);
                return dto;
            }else{
                //비밀번호 불일치
            }
        }else{
            //조회된 결과가 없다면
            return null;
        }
        return null;

    }
}
