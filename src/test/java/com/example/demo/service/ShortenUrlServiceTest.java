package com.example.demo.service;

import com.example.demo.application.UrlShortenerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class ShortenUrlServiceTest {

    @Autowired
    UrlShortenerService urlShortenerService;

    @Test
    void shortenUrlTest() { // create와 getDestination 모두 테스트
        String requestUrl = "https://www.naver.com";

        String newUrl = urlShortenerService.createUrl(requestUrl);
        String destination = urlShortenerService.getDestination(newUrl);

        assertTrue(destination.equals(requestUrl));
    }
}
