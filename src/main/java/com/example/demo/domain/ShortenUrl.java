package com.example.demo.domain;

import javax.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Getter;
import org.springframework.validation.annotation.Validated;

@Getter
public class ShortenUrl {
    private long id;
    @NotEmpty
    private String destination;
    @NotEmpty
    private String newUrl;
    private int cnt;
    private long sequence = 0L;

    @Builder
    public ShortenUrl(String destination, String newUrl){
        this.id = ++sequence;
        this.destination = destination;
        this.newUrl = newUrl;
        this.cnt = 0;
    }

    public void countUp() {
        this.cnt = this.cnt + 1;
    }

};
