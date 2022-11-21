package com.example.demo.controller;

import com.example.demo.application.UrlShortenerService;
import com.example.demo.presentation.UrlShortenerController;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(UrlShortenerController.class)
public class UrlShortenerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UrlShortenerService service;

    @Test
    @DisplayName("단축 url 생성")
    public void createUrlTest() throws Exception{

        mockMvc.perform(MockMvcRequestBuilders.post("/url")
                .contentType(MediaType.APPLICATION_JSON)
                .content("https://naver.com")
        ).andExpect(status().isOk());
    }

    @Test
    @DisplayName("기존 url 가져오기")
    public void getUrlTest() throws Exception{
        given(service.getDestination("http://localhost:8080/abcdefg")).willReturn("http://naver.com");
        mockMvc.perform(MockMvcRequestBuilders.get("/url/{newUrl}","abcdefg"))
                .andExpect(status().isOk())
                .andDo(print());
    }

}
