package com.example.shopping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdmController {
    @GetMapping("/adm")
    public String admForm(){
        return "admin";
    }

    @GetMapping("/admForm")
    public String admForm1() {
        return "admForm";
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
