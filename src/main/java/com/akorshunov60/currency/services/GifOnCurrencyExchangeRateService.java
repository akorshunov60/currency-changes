package com.akorshunov60.currency.services;

import org.springframework.http.ResponseEntity;

public interface GifOnCurrencyExchangeRateService {
    ResponseEntity<byte[]> getGifByCurrency(String base);
}
