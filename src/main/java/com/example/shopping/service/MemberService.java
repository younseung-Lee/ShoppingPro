package com.example.shopping.service;

import com.example.shopping.dto.AdmDTO;
import com.example.shopping.dto.MemberDTO;
import com.example.shopping.entity.AdmEntity;
import com.example.shopping.entity.MemberEntity;
import com.example.shopping.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    public void save(MemberDTO memberDTO) {
        MemberEntity memberEntity = MemberEntity.toMemberEntity(memberDTO);
        memberRepository.save(memberEntity);
    }

    public String idCheck(String userId) {
        Optional<MemberEntity> byUserId = memberRepository.findByUserId(userId);
        if(byUserId.isPresent()){
            //조회결과가 있다면 -> 등록된 아이디가 있다.(사용할 수 없다)
            return null;
        }else{
            //조회결과가 없다면 -> 사용가능하다.
            return "ok";
        }
    }

    public MemberDTO login(MemberDTO memberDTO) {
        //입력된 아이디를 db에서 조회 --> db에 있는 비번과 입력된 비번이 일치하는지 확인U
        Optional<MemberEntity> byUserId = memberRepository.findByUserId(memberDTO.getUserId());
        if (byUserId.isPresent()){
            //조회된 결과가 있다면
            MemberEntity memberEntity = byUserId.get();
            if(memberEntity.getUserPass().equals(memberDTO.getUserPass())){
                //비밀번호가 일치하면
                //entity --> dto 변환 후에 처리해야함
                MemberDTO dto = MemberDTO.toMemberDTO(memberEntity);
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