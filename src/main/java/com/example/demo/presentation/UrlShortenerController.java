package com.example.demo.presentation;

import com.example.demo.application.UrlShortenerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class UrlShortenerController {
    //		다음 요구사항을 만족하는 단축 URL 생성 API 개발
    //		- 단축 URL 생성 기능
    //		- 생성된 단축 URL로 요청시 원래 URL로 리다이렉트
    private final UrlShortenerService urlShortenerService;
    private final StringRedisTemplate redisTemplate;

    // 특정 자원에 대해 생성, 조회(id -> 단축된 문자열)
    //Q. 왜 requestParam 인쓰고 @RequestBody
    //Q. Interface 쓰는 이유
    @RequestMapping(path = "/url" ,method = RequestMethod.POST)
    public String create(@RequestBody String destination){
        String shortUrl = urlShortenerService.createUrl(destination);

        ValueOperations<String, String> ops = redisTemplate.opsForValue();
        //ops.set(key, shortUrl);

        return shortUrl;
    }

    //		- 생성된 단축 URL로 요청시 원래 URL로 리다이렉트
    @RequestMapping(path = "/url/{newUrl}", method = RequestMethod.GET)
    public String get(@PathVariable(value = "newUrl") String newUrl){
        String destination = urlShortenerService.getDestination(newUrl);
        ValueOperations<String, String> ops = redisTemplate.opsForValue();
        //ops.get("key");
        return destination;
    }

};
