package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}


/**	bitly 같은 URL 단축 서비스 만들기
		1. 단축 URL 생성 기능
//		2. 생성된 단축 URL로 요청시 원래 URL로 리다이렉트
//		데이터 저장은 DB가 아닌 컬렉션에 저장 ( 애플리케이션 재 시작시 데이터가 날아가니 db 전환 필요)
//		단축 URL로 어떤 값을 사용할 것 인가? -> base58... uuid
//		나중에 프론트엔드 페이지가 추가된다면 이 API 서버가 그대로 활용될 수 있을까?
*/

