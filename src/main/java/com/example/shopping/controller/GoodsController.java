package com.example.shopping.controller;

import com.example.shopping.dto.GoodsDTO;
import com.example.shopping.dto.NoticeDTO;
import com.example.shopping.service.GoodsService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class GoodsController {
    private final GoodsService goodsService;
    @GetMapping("/goods/detail/{id}")
    public String findById(@PathVariable Long id, Model model){

       GoodsDTO goodsDTO = goodsService.findById(id);
        model.addAttribute("goods", goodsDTO);
        return "/goods/detail";
    }

    @PostMapping("/goods/buy")
    public String goods_buy(){
        return "/goods/buy";
    }

    @GetMapping("/goods/qna")
    public String goods_qna(){
        return "/goods/qna";
    }
}
