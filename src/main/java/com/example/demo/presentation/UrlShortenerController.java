package com.example.demo.presentation;

import com.example.demo.application.UrlShortenerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UrlShortenerController {
    //		다음 요구사항을 만족하는 단축 URL 생성 API 개발
    //		- 단축 URL 생성 기능
    //		- 생성된 단축 URL로 요청시 원래 URL로 리다이렉트
    private UrlShortenerService urlShortenerService;

    @Autowired
    public UrlShortenerController(UrlShortenerService urlShortenerService) {
        this.urlShortenerService = urlShortenerService;
    }

    // 특정 자원에 대해 생성, 조회(id -> 단축된 문자열)
    //Q. 왜 requestParam 인쓰고 @RequestBody
    @RequestMapping(path = "/url" ,method = RequestMethod.POST)
    public String create(@RequestBody String destination){
        // 서비스를 호출 -> 서비스에 대한 인터페이스
        // Q. 인터페이스가 왜 필요한가?
        String shortUrl = urlShortenerService.createUrl(destination);
        System.out.println(shortUrl);
        return shortUrl;
    }

    //		- 생성된 단축 URL로 요청시 원래 URL로 리다이렉트
    @RequestMapping(path = "/url/{newUrl}", method = RequestMethod.GET)
    public String search(@PathVariable(value = "newUrl") String newUrl){
        String destination = urlShortenerService.getUrl(newUrl);
        return destination;
    }

};
