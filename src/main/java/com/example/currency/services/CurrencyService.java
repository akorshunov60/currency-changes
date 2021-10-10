package com.example.currency.services;

import com.example.currency.dto.CurrencyDTO;
import org.springframework.http.ResponseEntity;

public interface CurrencyService {
    ResponseEntity<CurrencyDTO> getCurrency(String date, String base);
}
