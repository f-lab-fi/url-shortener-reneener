package com.example.demo.service;

import com.example.demo.application.UrlShortenerService;
import com.example.demo.domain.exception.ManyDuplicationException;
import com.example.demo.domain.exception.UrlFormatException;
import com.example.demo.domain.ShortenUrlRepository;
import org.junit.jupiter.api.DisplayName;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


/*

테스트가 필요한 로직
1. 단축 url 생성 횟수 초과 (중복) -> 예외발생
2. 요청 url 형식 확인 -> 예외발생
3. getDestination 시 이전에 생성한 url이 없을 경우 -> false 리턴

*/

@ExtendWith(MockitoExtension.class)
public class ShortenUrlServiceUnitTest {

    @Mock
    ShortenUrlRepository shortenUrlRepository;

    @InjectMocks
    UrlShortenerService urlShortenerService;

    @Test
    @DisplayName("url 중복 예외 발생 테스트")
    void testDuplicatedRuntimeException() {
        //when
        //테스트 해야할 createUrl에서 repository에 의존을 하므로 중복로직 체크를 true로 가정
        when(shortenUrlRepository.checkUrl(any())).thenReturn(true); //

        //then
        //중복시 예외가 발생함을 테스트
        assertThrows(ManyDuplicationException.class, () -> {
            urlShortenerService.createUrl("https://www.naver.com");
        });
    }

    @Test
    @DisplayName("생성된 단축 url 자릿수가 7자리인지 테스트")
    void testUrlDigit(){
        assertTrue(urlShortenerService.createUrl("http://naver.com").length() == 7);
    }

    @Test
    @DisplayName("url validation check 예외 발생 테스트")
    void testUrlFormatRuntimeException(){
        assertThrows(UrlFormatException.class, () -> {
           urlShortenerService.createUrl("kkk");
        });
    }

    @Test
    @DisplayName("기존에 저장된 destination이 없는 예외 발생 테스트")
    void testNotexistedShortenUrl(){
        //service만 mock한거지 의존하고 있는 repository에서 확인할 수 없음
   }

};
