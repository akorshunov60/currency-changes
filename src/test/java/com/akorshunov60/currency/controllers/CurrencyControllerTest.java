package com.akorshunov60.currency.controllers;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CurrencyControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Проверка ответа")
    public void getResponse() throws Exception {
        mockMvc.perform(get("/api/"))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Получение GIF")
    public void getGif() throws Exception {
        mockMvc.perform(get("/api/gif/")
                        .param("base", "USD"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.IMAGE_GIF));
    }

    @Test
    @DisplayName("Некорректный base - параметр")
    public void getGifBadGateWay() throws Exception {
        mockMvc.perform(get("/api/gif/")
                        .param("base", "BADBASE"))
                .andExpect(status().isBadRequest());
    }
}
