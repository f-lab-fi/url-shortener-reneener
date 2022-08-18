package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/*
도메인 대신 DTO를 사용하는 이유
*/
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ShortenUrlDto {
    private String destination; // 필요한 자원만 정의
}
