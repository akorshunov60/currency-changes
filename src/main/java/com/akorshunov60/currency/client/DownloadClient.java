package com.akorshunov60.currency.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.net.URI;

@FeignClient(name = "download-gif-client", url = "${download-gif.url}")
public interface DownloadClient {

    @GetMapping
    ResponseEntity<byte[]> getGifByUrl(URI baseUrl);
}
