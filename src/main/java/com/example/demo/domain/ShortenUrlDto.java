package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*도메인 대신 DTO를 사용하는 이유
 도메인 캡슐화, 비즈니스 로직과 관계없는 레이어는 도메인 자원 접근 가능 못하도록 하기 위해
*/
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ShortenUrlDto {
    private String destination; // 필요한 자원만 정의

}
