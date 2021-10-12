package com.example.currency.services;

import org.springframework.http.ResponseEntity;

import java.net.URI;

public interface DownloadService {
    ResponseEntity<byte[]> getGifByUrl(URI url);
}
