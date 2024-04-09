package com.example.shopping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class GoodsController {
    @GetMapping("/goods")
    public String goods(){
        return "goods";
    }

    @GetMapping("/goods/detail")
    public String goods_detail() {
        return "/goods/detail";
    }

    @PostMapping("/goods/buy")
    public String goods_buy(){
        return "/goods/buy";
    }

    @GetMapping("/goods/qna")
    public String goods_qna (){
        return "/goods/qna";
    }
}
