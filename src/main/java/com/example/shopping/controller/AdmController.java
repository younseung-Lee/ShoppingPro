package com.example.shopping.controller;

import com.example.shopping.dto.AdmDTO;
import com.example.shopping.service.AdmService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class AdmController {
    //생성자 주입
    private final AdmService admService;
    @GetMapping("/adm")
    public String admForm(){
        return "admin";
    }

    @GetMapping("/admForm")
    public String admForm1() {
        return "admForm";
    }

    @PostMapping("/admSuccess")
    public String admSuccess(@ModelAttribute AdmDTO admDTO) {
        System.out.println("admDTO = " + admDTO);
        admService.save(admDTO);
        return "admForm";
    }

    @PostMapping("/admSave")
    public String admSave(@ModelAttribute AdmDTO admDTO, HttpSession session){
        AdmDTO loginResult = admService.login(admDTO);
        if (loginResult != null){
            //로그인 성공
            session.setAttribute("admName", loginResult.getAdmName());
            return "/adm/index";
        } else {
            return "/";
        }

    }

    @GetMapping("/admOk")
    public String admOk(){
        return "/adm/index";
    }

    @GetMapping("/adm/goods")
    public String admGoods(){
        return "/adm/goods";
    }

    @GetMapping("/adm/goodsWrite")
    public String admGoodsWrite(){
        return "/adm/goodsWrite";
    }


}
