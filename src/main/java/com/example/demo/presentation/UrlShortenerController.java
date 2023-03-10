package com.example.demo.presentation;

import com.example.demo.application.UrlShortenerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RequiredArgsConstructor
@RestController
public class UrlShortenerController {
    //		다음 요구사항을 만족하는 단축 URL 생성 API 개발
    //		- 단축 URL 생성 기능
    //		- 생성된 단축 URL로 요청시 원래 URL로 리다이렉트
    private final UrlShortenerService urlShortenerService;

    // 특정 자원에 대해 생성, 조회(id -> 단축된 문자열)
    //Q. 왜 requestParam 인쓰고 @RequestBody
    //Q. Interface 쓰는 이유
    @RequestMapping(path = "/url" ,method = RequestMethod.POST)
    public String create(@RequestBody String destination){
        String shortUrl = urlShortenerService.createUrl(destination);
<<<<<<< HEAD
        //ModelAndView view = new ModelAndView("url");
        //view.addObject("newUrl", shortUrl);
        return "content/main";
=======

        //ops.set(key, shortUrl);

        return shortUrl;
>>>>>>> 7fd170a04dbdd1069cb6922de39625a6874894ca
    }

    //		- 생성된 단축 URL로 요청시 원래 URL로 리다이렉트
    @RequestMapping(path = "/url/{newUrl}", method = RequestMethod.GET)
    public ModelAndView search(@PathVariable(value = "newUrl") String newUrl){
        String destination = urlShortenerService.getDestination(newUrl);
<<<<<<< HEAD
        ModelAndView view = new ModelAndView("url");
        view.addObject("destination", destination);
        return view;
=======
        //ops.get("key");
        return destination;
>>>>>>> 7fd170a04dbdd1069cb6922de39625a6874894ca
    }

};
