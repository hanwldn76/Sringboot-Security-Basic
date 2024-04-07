package com.cos.security1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller // view를 리턴
public class IndexController {
    // localhost:8080/
    // localhost:8080
    @GetMapping({"", "/"})
    public String index(){
        // mustache 사용
        // src/main/resources/
        // 뷰리졸버 설정 : templates(prefix), .mustache(suffix) 생략 가능
        return "index"; // src/main/resources/templates/index.mustache
    }

    @GetMapping("/user")
    public @ResponseBody String user(){
        return "user";
    }

    @GetMapping("/admin")
    public @ResponseBody String admin(){
        return "admin";
    }

    @GetMapping("/manager")
    public @ResponseBody String manager(){
        return "manager";
    }

    // 스프링 시큐리티가 해당 주소를 낚아챔(수정 예정)
    // SecurityConfig 파일 생성 후 작동 안함(낚아채지않고 login으로만 응답)
    @GetMapping("/login")
    public @ResponseBody String login(){
        return "login";
    }

    @GetMapping("/join")
    public @ResponseBody String join(){
        return "join";
    }

    @GetMapping("/joinProc")
    public @ResponseBody String joinProc(){
        return "회원가입 완료됨!";
    }
}
