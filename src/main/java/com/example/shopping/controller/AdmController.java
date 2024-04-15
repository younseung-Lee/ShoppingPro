package com.example.shopping.controller;


import com.example.shopping.dto.AdmDTO;
import com.example.shopping.dto.NoticeDTO;
import com.example.shopping.service.AdmService;
import com.example.shopping.service.NoticeService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor //Service 생성자 주입을 위한 어노테이션
public class AdmController {
    //생성자 주입
    private final AdmService admService;
    private final NoticeService noticeService;

    //임포트?
    @GetMapping("/adm/notice")
    public String notice_list(Model model){
        List<NoticeDTO> noticeDTOList = noticeService.findAll();
        model.addAttribute("noticeList", noticeDTOList);
        return "/adm/noticeList";
    }

    @GetMapping("/adm/noticeWrite")
    public String notice_write(){
        return "/adm/noticeWrite";
    }

    @PostMapping("/adm/noticeSave")
    public String noticeSave(@ModelAttribute NoticeDTO noticeDTO){
        System.out.println("noticeDTO =" + noticeDTO);
        noticeService.save(noticeDTO); //noticeDTO를 서비스에 save시키겠다
        return "/adm/noticeList";
    }

    @GetMapping("/adm")
    public String admForm(){
        return "admin";
    }

    @GetMapping("/admForm")
    public String admForm1(){
        return "admForm";
    }

    // /admSuccess경로를 post로 받았을 때, /admsave으로 이동
    //관리자 페이지에서 post로 받은 데이터들을 @RequestParam을 통해 받아옴.
    @PostMapping("/admSuccess")
    public String admSuccess(@ModelAttribute AdmDTO admDTO){ //AdmDTO에서 포장했던 것들을 받아온다.
        System.out.println("admDTO = " + admDTO);
        admService.save(admDTO); //AdmService에 admDTO를 save한다?
        return "admForm";
    }

    //로그인 처리된 값을 loginresult에 담는다
    @PostMapping("/admSave")
    public String admSave(@ModelAttribute AdmDTO admDTO, HttpSession session){ //로그인했을때 세션을 발생시킴
        AdmDTO loginResult = admService.login(admDTO);
        if (loginResult != null){
            //로그인 성공
            session.setAttribute("admName", loginResult.getAdmName());
            return "/adm/index";
        }else{
            //로그인 실패
            return "/";
        }

    }

    //관리자 등록이 완료되면 index페이지로 돌아감
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
