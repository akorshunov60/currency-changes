package com.example.currency.services;

import org.springframework.http.ResponseEntity;

public interface GifOnCurrencyExchangeRateService {
    ResponseEntity<byte[]> getGifByCurrency(String base);
}
