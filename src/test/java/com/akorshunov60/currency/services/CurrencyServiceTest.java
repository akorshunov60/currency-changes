package com.akorshunov60.currency.services;

import com.akorshunov60.currency.dto.CurrencyDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CurrencyServiceTest {

    private final String CURRENCY_CODE = "RUB";
    private final String DATE_FORMAT = "yyyy-MM-dd";

    @Autowired
    private CurrencyService currencyService;

    @Test
    @DisplayName("Проверка корректности ответа от currency api")
    public void getCurrency() {
        String date = DateTimeFormatter.ofPattern(DATE_FORMAT, Locale.ENGLISH).format(LocalDateTime.now());
        ResponseEntity<CurrencyDTO> response = currencyService.getCurrency(date,"USD");
        assertAll(
                () -> assertEquals(response.getStatusCodeValue(), 200),
                () -> assertNotNull(response.getBody()),
                () -> assertNotNull(Objects.requireNonNull(response.getBody()).getRates().get(CURRENCY_CODE))
        );
    }
}
