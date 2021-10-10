package com.example.currency.services.Impl;

import com.example.currency.client.DownloadClient;
import com.example.currency.services.DownloadService;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.URI;

@Data
@Service
public class DownloadServiceImpl implements DownloadService {

    private final DownloadClient downloadClient;

    @Override
    public ResponseEntity<byte[]> getGifByUrl(URI uri) {
        return downloadClient.getGifByUrl(uri);
    }
}
