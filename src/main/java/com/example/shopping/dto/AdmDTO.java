package com.example.shopping.dto;
//폼에서 넘어온 것들을 다시 새롭게 담아서 처리하거나 뿌려준다 = DTO
//입력했던 관리자정보폼을 AdmDTO에 담는다.(포장한다)
import com.example.shopping.entity.AdmEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class AdmDTO {
    private Long id; //고유번호?
    private String admId;
    private String admPass;
    private String admName;


    //서비스에서 entity --> dto 변환을 위한 코드
    public static AdmDTO toAdmDTO(AdmEntity admEntity){
        AdmDTO admDTO = new AdmDTO();
        admDTO.setId(admDTO.getId());
        admDTO.setAdmId(admDTO.getAdmId());
        admDTO.setAdmPass(admDTO.getAdmPass());
        admDTO.setAdmName(admDTO.getAdmName());
        return admDTO;
    }
}
