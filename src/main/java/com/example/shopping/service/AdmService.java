package com.example.shopping.service;

import com.example.shopping.dto.AdmDTO;
import com.example.shopping.repository.AdmRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AdmService {
    private final AdmRepository admRepository;
    public static void save(AdmDTO admDTO) {
    }
}
