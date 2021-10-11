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
На сервис написаны тесты (для мока внешних сервисов можно использовать @mockbean или WireMock).   
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

Then to start our container, we can simply run:
'docker run -it -p9090:8080 currency-changes:1.0.0'
As with our built image, we need to map the port to make our Spring Boot application
accessible from outside Docker.

## Endpoints
- `/api/gif`  
Возвращает gif в зависимости от курса валют   
**Parameters**   
base: string (USD)   
**_Пример_**   
`http://localhost:9090/api/gif?base=USD`
------
- `/api/*`  
Возвращает gif в зависимости от курса валюты (USD)    
**_Пример_**   
`http://localhost:9090/api/*`
***
 ## Примечание
 - API, представляющее gif бесплатно только для базовой валюты USD.
 - Список доступных валют можно посмотреть [здесь](https://openexchangerates.org/api/currencies.json)
 - Добавлено только один кастомный exception.
 - В качестве примера добавлены тесты на контроллер и один сервис.
 - API далек от совершенства... в дальнейшем будет улучшаться в рамках изучения Spring Cloud.
 - Логгироание только одного сервиса.
 - С началом нового дня курс за текущий день недоступен, поэтому приложение будет выдавать ошибку.