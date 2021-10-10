package com.example.currency.services;

import com.example.currency.dto.GifDTO;
import org.springframework.http.ResponseEntity;

public interface GifService {
    ResponseEntity<GifDTO> getGifResponse(String tag);
}
