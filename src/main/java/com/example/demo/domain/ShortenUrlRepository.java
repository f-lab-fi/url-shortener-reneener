package com.example.demo.domain;

//왜 service를 interface로 만들지 않고 repository를 만드는지
import com.example.demo.domain.ShortenUrl;

public interface ShortenUrlRepository {
    void createShortenUrl(ShortenUrl url);
    String getDestination (String newUrl);
    boolean checkUrl(String newUrl);
}
