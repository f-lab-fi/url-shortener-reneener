package com.example.demo.presentation;

import com.example.demo.application.UrlShortenerService;
import com.example.demo.domain.ShortenUrlDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.HashMap;

@RestController
public class UrlShortenerController {
    //		다음 요구사항을 만족하는 단축 URL 생성 API 개발
    //		- 단축 URL 생성 기능
    //		- 생성된 단축 URL로 요청시 원래 URL로 리다이렉트
    private UrlShortenerService urlShortenerService;

    public UrlShortenerController(UrlShortenerService urlShortenerService) {
        this.urlShortenerService = urlShortenerService;
    }

    // 특정 자원에 대해 생성, 조회(id -> 단축된 문자열)
    //Q. 왜 requestParam 인쓰고 @RequestBody
    //Q. Interface 쓰는 이유
    @RequestMapping(path = "/url" ,method = RequestMethod.POST)
    public String create(@RequestBody ShortenUrlDto destination){
        String shortUrl = urlShortenerService.createUrl(destination.getDestination());
        return shortUrl;
    }

    //		- 생성된 단축 URL로 요청시 원래 URL로 리다이렉트
    @RequestMapping(path = "/url/{newUrl}", method = RequestMethod.GET)
    public ResponseEntity<?> search(@PathVariable(value = "newUrl") @RequestBody ShortenUrlDto newUrl){
        String destination = urlShortenerService.getDestination(newUrl.getDestination());
        HttpHeaders header = new HttpHeaders();
        header.setLocation(URI.create(destination));
        return new ResponseEntity<>(header, HttpStatus.MOVED_PERMANENTLY);
    }

};
