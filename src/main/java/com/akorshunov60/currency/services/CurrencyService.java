package com.akorshunov60.currency.services;

import com.akorshunov60.currency.dto.CurrencyDTO;
import org.springframework.http.ResponseEntity;

public interface CurrencyService {
    ResponseEntity<CurrencyDTO> getCurrency(String date, String base);
}
