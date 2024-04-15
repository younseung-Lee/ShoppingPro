package com.example.shopping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberController {
    @GetMapping("/member/login")
    public String login(){
        return "member/login";
    }

    @GetMapping("member/join")
    public String join(){
        return "/member/join";
    }
}
