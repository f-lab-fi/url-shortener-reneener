package com.example.demo.presentation;

import com.example.demo.application.UrlShortenerService;
import com.example.demo.domain.ShortenUrl;
import com.example.demo.domain.ShortenUrlDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
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

    //Q. 왜 requestParam 인쓰고 @RequestBody
    //Q. Interface 쓰는 이유
    //Q. Dto를 쓰는 이유
    @RequestMapping(path = "/url" ,method = RequestMethod.POST)
    public String create(@RequestBody ShortenUrlDto destination){
        String shortUrl = urlShortenerService.createUrl(destination.getDestination());
        return shortUrl;
    }

    //생성된 단축 URL로 요청시 원래 URL로 리다이렉트
    @RequestMapping(path = "/url/{newUrl}", method = RequestMethod.GET)
    public ResponseEntity<?> redirect(@PathVariable(value = "newUrl") @RequestBody String newUrl) throws URISyntaxException {
        String destination = urlShortenerService.getDestination(newUrl);
        URI redirectUri = new URI(destination);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(redirectUri);
        return new ResponseEntity<>(httpHeaders, HttpStatus.MOVED_PERMANENTLY);
    }

    //생성된 단축 URL로 원본 URL 찾기
    @RequestMapping(path = "/search/{newUrl}", method = RequestMethod.GET)
    public String search(@PathVariable(value = "newUrl") String newUrl) {
        System.out.println(newUrl);
        String destination = urlShortenerService.getDestination(newUrl);
        return destination;
    }

};
