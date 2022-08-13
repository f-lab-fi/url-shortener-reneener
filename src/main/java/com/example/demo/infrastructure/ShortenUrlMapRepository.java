package com.example.demo.infrastructure;

import com.example.demo.domain.ShortenUrl;
import com.example.demo.domain.ShortenUrlRepository;
import com.example.demo.domain.exception.NewUrlNotFoundException;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Profile("map")
@Repository
public class ShortenUrlMapRepository implements ShortenUrlRepository{

    private Map<String, ShortenUrl> urls = new HashMap<>();

    public void createShortenUrl(ShortenUrl shortenUrl) {
        urls.put(shortenUrl.getDestination(), shortenUrl);
    }

    public boolean checkUrl(String newUrl){
        for(ShortenUrl url : urls.values()){
            if(url.getNewUrl().equals(newUrl))
                return true;
        }
        return false;
    }

    public String getDestination (String newUrl){ // 리다이렉트
        for(ShortenUrl url : urls.values()){
            if(url.getNewUrl().equals(newUrl)){
                url.countUp();
                return url.getDestination();
            }
        }
        throw new NewUrlNotFoundException("이전 url 정보를 찾을 수 없습니다.");
    }

};
