package com.example.currency.services.Impl;

import com.example.currency.client.GifClient;
import com.example.currency.dto.GifDTO;
import com.example.currency.services.GifService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Data
@Service
public class GifServiceImpl implements GifService {

    private final GifClient gifClient;

    private final String API_KEY;

    public GifServiceImpl(GifClient gifClient, @Value("${gif.api_key}") String API_KEY) {
        this.gifClient = gifClient;
        this.API_KEY = API_KEY;
    }

    public ResponseEntity<GifDTO> getGifResponse(String tag) {
        return gifClient.getGif(API_KEY, tag);
    }}
