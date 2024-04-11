package com.example.shopping.dto;

import com.example.shopping.entity.AdmEntity;
import lombok.*;
import org.springframework.web.bind.annotation.GetMapping;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class AdmDTO {
    private Long id;
    private String admId;
    private String admPass;
    private String admName;

    public static AdmDTO toAdmDTO(AdmEntity admEntity){
        AdmDTO admDTO = new AdmDTO();
        admDTO.setId(admDTO.getId());
        admDTO.setAdmId(admDTO.getAdmId());
        admDTO.setAdmPass(admDTO.getAdmPass());
        admDTO.setAdmName(admDTO.getAdmName());
        return admDTO;
    }
}
