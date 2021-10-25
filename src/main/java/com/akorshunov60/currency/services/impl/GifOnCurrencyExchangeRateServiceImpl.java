package com.akorshunov60.currency.services.impl;

import com.akorshunov60.currency.dto.CurrencyDTO;
import com.akorshunov60.currency.dto.GifDTO;
import com.akorshunov60.currency.exceptions.BadBaseException;
import com.akorshunov60.currency.services.CurrencyService;
import com.akorshunov60.currency.services.DownloadService;
import com.akorshunov60.currency.services.GifOnCurrencyExchangeRateService;
import com.akorshunov60.currency.services.GifService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Objects;

@Data
@Slf4j(topic = "GifOnCurrencyExchangeRateService")
@Service
public class GifOnCurrencyExchangeRateServiceImpl implements GifOnCurrencyExchangeRateService {

    private static final int TODAY = 0; // интервал для форматирования даты от текущего значения
    private static final int YESTERDAY = 1; // интервал для форматирования даты от текущего значения
    private static final String CURRENCY_CODE = "RUB";
    private static final String DATE_FORMAT = "yyyy-MM-dd";

    private final GifService gifService;
    private final CurrencyService currencyService;
    private final DownloadService downloadService;

    public ResponseEntity<byte[]> getGifByCurrency(@Value("${currency.base}") String base) {
        log.info("Поиск gif по курсу начат");
        if (isBaseNotValid(base)) {
            log.error("Код валюты невалиден");
            throw new BadBaseException("Код валюты должен состоять из 3-х символов");
        }
        log.info("Текущий код валюты: {}", base);
        String todayDate = getFormatDateFromNow(TODAY);
        String yesterdayDate = getFormatDateFromNow(YESTERDAY);
        double todayRate = getRateByDateAndBase(todayDate, base);
        double yesterdayRate = getRateByDateAndBase(yesterdayDate, base);
        String tag = (todayRate > yesterdayRate) ? "rich" : "broke";
        log.info("Текущий tag для валюты: {}", tag);
        URI basePathUri = URI.create(getGifUrlByTag(tag));
        return downloadService.getGifByUrl(basePathUri);
    }

    private boolean isBaseNotValid(String base) {
        return base.length() != 3;
    }

    private String getFormatDateFromNow(int days) {
        LocalDateTime dateTime = LocalDateTime.now().minusDays(days);
        String dateFromNow = DateTimeFormatter.ofPattern(DATE_FORMAT, Locale.ENGLISH).format(dateTime);
        log.info("Дата с учетом вычета {} дней : {}", days, dateFromNow);
        return dateFromNow;
    }

    private double getRateByDateAndBase(String date, String base) {
        CurrencyDTO currencyDTO = currencyService.getCurrency(date, base.toUpperCase()).getBody();
        double rate = Objects.requireNonNull(currencyDTO).getRates().get(CURRENCY_CODE);
        log.info("Курс рубля на {}: {}", date, rate);
        return rate;
    }

    private String getGifUrlByTag(String tag) {
        GifDTO gifDTO = gifService.getGifResponse(tag).getBody();
        String url = String.valueOf(Objects.requireNonNull(gifDTO).getData().get("image_original_url"));
        log.info("Текущий URL gif: {}", url);
        return url;
    }
}
