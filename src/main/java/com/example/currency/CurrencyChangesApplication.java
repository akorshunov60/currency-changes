package com.example.currency;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/*
Создать сервис, который обращается к сервису курсов валют, и отдает gif в ответ:
если курс по отношению к рублю за сегодня стал выше вчерашнего,
то отдаем рандомную отсюда https://giphy.com/search/rich,
если ниже - отсюда https://giphy.com/search/broke.

Ссылки
REST API курсов валют - https://docs.openexchangerates.org/.
REST API gif - https://developers.giphy.com/docs/api#quick-start-guide.

Must Have
Сервис на Spring Boot 2 + Java / Kotlin.
Запросы приходят на HTTP endpoint, туда передается код валюты.
Для взаимодействия с внешними сервисами используется Feign.
Все параметры (валюта по отношению к которой смотрится курс, адреса внешних сервисов и т.д.)
вынесены в настройки.
На сервис написаны тесты (для мока внешних сервисов можно использовать @mockbean или WireMock).
Для сборки должен использоваться Gradle.
Результатом выполнения должен быть репо на GitHub с инструкцией по запуску.

Nice to Have
Сборка и запуск Docker контейнера с этим сервисом

Срок выполнения задания - 1 неделя) удачи!
 */

@EnableFeignClients
@SpringBootApplication
public class CurrencyChangesApplication {

    public static void main(String[] args) {
        SpringApplication.run(CurrencyChangesApplication.class, args);
    }
}
