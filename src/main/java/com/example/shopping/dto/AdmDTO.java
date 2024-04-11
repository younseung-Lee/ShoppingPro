package com.example.shopping.dto;

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
}
