# CURRENCY EXCHANGE RATES -> GIF RECEIVER

## Техническое задание
Создать сервис, который обращается к сервису курсов валют, и отдает gif в ответ:
если курс по отношению к рублю за сегодня стал выше вчерашнего,
то отдаем рандомную [отсюда](https://giphy.com/search/rich),
если ниже - [отсюда](https://giphy.com/search/broke).

**Ссылки**
[REST API курсов валют](https://docs.openexchangerates.org/)
[REST API gif](https://developers.giphy.com/docs/api#quick-start-guide)

**Must Have**
Сервис на Spring Boot 2 + Java / Kotlin
Запросы приходят на HTTP endpoint, туда передается код валюты
Для взаимодействия с внешними сервисами используется Feign
Все параметры (валюта по отношению к которой смотрится курс, адреса внешних сервисов и т.д.)
вынесены в настройки.
На сервис написаны тесты (для мока внешних сервисов можно использовать @Mockbean или WireMock).
Для сборки должен использоваться Gradle.
Результатом выполнения должен быть репо на GitHub с инструкцией по запуску.
**Nice to Have**
Сборка и запуск Docker контейнера с этим сервисом.
***

## Stack
- Open JDK 11    
- Spring Boot 2.5.5
- Spring Cloud(OpenFeign)  
- Lombok
- Slf4j
- JUnit 5
***
Инструкция по установке и запуску приложения в Docker:
В Unix терминале войти в директорию, куда предварительно склонировать проект с GITHub по ссылке:
https://github.com/akorshunov60/currency-changes.
Для дальнейшей работы необходимо, чтобы был установлен и запущен Docker.
Далее для запуска необходимо:

1. Spring Boot 2.3 added support for buildpacks.
Put simply, instead of creating our own Dockerfile
and building it using something like docker build,
all we have to do is issue the following command:

'$ ./gradlew bootBuildImage'

For this to work, we need to have Docker installed and running.

2. When we list the available docker images:'docker image ls -a'
We see a line for the image we just created:'currency-changes 1.0.0'
3. Then to start our container, we can simply run:

'docker run -it -p18888:8888 currency-changes:1.0.0'

As with our built image, we need to map the port to make our Spring Boot application
accessible from outside Docker.

## Endpoints

- `/api/gif`  
Возвращает gif в зависимости от курса валют
Parameters:
base: string (USD)
Пример: `http://localhost:18888/api/gif?base=USD`

- `/api/*`  
Возвращает gif в зависимости от курса валюты.
Пример: `http://localhost:18888/api/*`

 ## Примечание:

 - API, предоставляет бесплатно exchange rates только для base = USD.
   При запросе, например base = RUB/CAD/AUD, получим ошибку 403 с описанием:
"Changing the API `base` currency is available for Developer, Enterprise and Unlimited plan clients."
 - Список доступных валют [здесь](https://openexchangerates.org/api/currencies.json)
 - В модуле test два теста CurrencyControllerTest и CurrencyServiceTest.
 - Логирование одного сервиса GifOnCurrencyExchangeRateServiceImpl.
 - С началом нового дня курс за текущий день недоступен, поэтому приложение будет выдавать ошибку.