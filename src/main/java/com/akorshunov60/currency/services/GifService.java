package com.akorshunov60.currency.services;

import com.akorshunov60.currency.dto.GifDTO;
import org.springframework.http.ResponseEntity;

public interface GifService {
    ResponseEntity<GifDTO> getGifResponse(String tag);
}
