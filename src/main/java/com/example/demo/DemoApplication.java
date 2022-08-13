package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}


//	bitly 같은 URL 단축 서비스 만들기
//	개발하기 전에 bitly로 직접 단축 URL을 만들어보면서 원리를 생각해보시고 개발하세요.
//		다음 요구사항을 만족하는 단축 URL 생성 API 개발
//		단축 URL 생성 기능
//		생성된 단축 URL로 요청시 원래 URL로 리다이렉트
//		데이터 저장은 DB가 아닌 컬렉션에 저장(애플리케이션 재시작시 데이터가 날아가겠죠?)
//		Optional) 단축된 URL에 대한 요청 횟수 저장 및 요청 횟수 조회 기능
//		신경써야할 내용
//		단축 URL로 어떤 값을 사용할 것 인가?
//		나중에 프론트엔드 페이지가 추가된다면 이 API 서버가 그대로 활용될 수 있는가?


