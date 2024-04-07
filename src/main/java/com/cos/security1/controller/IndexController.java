package com.cos.security1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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
}
