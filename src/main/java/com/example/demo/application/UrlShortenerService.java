package com.example.demo.application;

import com.example.demo.domain.ShortenUrl;
import com.example.demo.domain.ShortenUrlRepository;
import com.example.demo.domain.exception.ManyDuplicationException;
import com.example.demo.domain.exception.UrlFormatException;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UrlShortenerService {

	private final ShortenUrlRepository shortenUrlRepository;

	public String createUrl(String destination) { //단축 url 생성
		checkValidation(destination);

		String newUrl = UUID.randomUUID().toString().substring(0, 7);
		int count = 0;

		while (count++ < 10) {
			if (notExistedUrl(newUrl)) { //랜덤 문자열 중복 체크
				ShortenUrl shortenUrl = new ShortenUrl(destination, newUrl);
				shortenUrlRepository.createShortenUrl(shortenUrl);
				return newUrl;
			}
		}
		throw new ManyDuplicationException("요청 횟수 초과");

	}

	public String getDestination(String newUrl) {
		return shortenUrlRepository.getDestination(newUrl);
	}

	private boolean notExistedUrl(String newUrl) {
		if (shortenUrlRepository.checkUrl(newUrl)) {
			return false;
		} else {
			return true;
		}
	}

	private void checkValidation(String text) {
		log.info("check validation {}", text);
		Pattern p = Pattern.compile(
			"^(http|https?):\\/\\/([^:\\/\\s]+)(:([^\\/]*))?((\\/[^\\s/\\/]+)*)?\\/?([^#\\s\\?]*)(\\?([^#\\s]*))?(#(\\w*))?$");
		Matcher m = p.matcher(text);
		if (Boolean.FALSE == m.matches()) {
			throw new UrlFormatException("URL 형식이 맞지 않습니다.");
		}
	}
}
