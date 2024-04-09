package com.example.shopping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GoodsController {
    @GetMapping("/goods")
    public String goods(){
        return "goods";
    }
}
