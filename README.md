Weather application

Сервис использует бесплатное API www.weatherapi.com. Токен выдается после регистрации.

В текущей версии выполнен один endpoint 
http://host:port/current?city=city_name&lang=language

По нему происходит запрос текущей погоды в переданном городе. 
Параметр city_name обязателен, lang опционален, по умолчанию используется русский язык. 

Примеры использования:
http://localhost:8081/current?city=Saratov
Ответ:
{"name":"Saratov","tempC":-9.4,"condition":"Переменная облачность"}

http://localhost:8081/current?city=Moscow&lang=eng
Ответ:
{"name":"Moscow","tempC":0.0,"condition":"Clear"}
