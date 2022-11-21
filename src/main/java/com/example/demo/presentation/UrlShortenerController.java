package com.example.demo.presentation;

import com.example.demo.application.UrlShortenerService;
import com.example.demo.domain.ShortenUrlDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequiredArgsConstructor
public class UrlShortenerController {

    private final UrlShortenerService urlShortenerService;

    //단축 url 생성
    @PostMapping("/url")
    public String create(@RequestBody ShortenUrlDto destination){
        String shortUrl = urlShortenerService.createUrl(destination.getDestination());
        return shortUrl;
    }

    //생성된 단축 URL로 요청시 원래 URL로 리다이렉트
    @GetMapping("/{newUrl}")
    public ResponseEntity<?> redirect(@PathVariable(value = "newUrl") @RequestBody String newUrl) throws URISyntaxException {
        String destination = urlShortenerService.getDestination(newUrl);
        URI redirectUri = new URI(destination);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(redirectUri);
        return new ResponseEntity<>(httpHeaders, HttpStatus.MOVED_PERMANENTLY);
    }

    //생성된 단축 URL로 원본 URL 찾기
    @GetMapping("/search/{newUrl}")
    public String search(@PathVariable(value = "newUrl") String newUrl) {
        String destination = urlShortenerService.getDestination(newUrl);
        return destination;
    }

};
