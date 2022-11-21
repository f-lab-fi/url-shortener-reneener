package com.example.demo.domain;

import javax.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ShortenUrlDto {
    @NotEmpty
    private String destination; // 필요한 자원만 정의
}
