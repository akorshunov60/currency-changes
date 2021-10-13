package com.akorshunov60.currency.services.impl;

import com.akorshunov60.currency.client.CurrencyClient;
import com.akorshunov60.currency.dto.CurrencyDTO;
import com.akorshunov60.currency.services.CurrencyService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Data
@Service
public class CurrencyServiceImpl implements CurrencyService {

    private final CurrencyClient currencyClient;
    private final String API_KEY;

    public CurrencyServiceImpl(CurrencyClient currencyClient,
                               @Value("${currency.api_key}") String API_KEY) {
        this.currencyClient = currencyClient;
        this.API_KEY = API_KEY;
    }

    public ResponseEntity<CurrencyDTO> getCurrency(String date, String base) {
        return currencyClient.getCurrency(date, API_KEY, base);
    }
}
