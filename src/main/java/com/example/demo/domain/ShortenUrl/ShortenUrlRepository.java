package com.example.demo.domain.ShortenUrl;

//왜 service를 interface로 만들지 않고 repository를 만드는지
<<<<<<< HEAD:src/main/java/com/example/demo/domain/ShortenUrlRepository.java
import com.example.demo.domain.ShortenUrl;
=======

import com.example.demo.domain.ShortenUrl.ShortenUrl;
import org.springframework.data.jpa.repository.JpaRepository;
>>>>>>> 7fd170a04dbdd1069cb6922de39625a6874894ca:src/main/java/com/example/demo/domain/ShortenUrl/ShortenUrlRepository.java

public interface ShortenUrlRepository {
    void createUrl(ShortenUrl url);
    String getDestination (String newUrl);
    boolean checkUrl(String newUrl);
}
