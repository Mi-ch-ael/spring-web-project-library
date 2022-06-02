# spring-web-project-library
Простое веб-приложение, написанное с использованием фреймворка Spring.

## Описание
Проект представляет собой переписанную на Java + Spring [лабораторную работу](https://github.com/Mi-ch-ael/web-lab2-REST-basics)
по дисциплине "web-технологии". Функционал приложения не изменился: можно просматривать и редактировать список имеющихся книг, "брать" и "возвращать"
книги. Технологии: Spring Boot, Spring Web, Spring Data JPA, Pug ([Pug4J for Spring](https://github.com/neuland/spring-pug4j)).

Моей задачей было переписывание серверной логики по [образцу](https://github.com/Mi-ch-ael/web-lab2-REST-basics),
по возможности с минимальными изменениями в шаблонах; кроме того, я организовал хранение списка книг в базе данных. Я пока не ставил перед собой задачу
изменения интерфейса пользователя, бизнес-логики или протокола взаимодействия между клиентом и сервером по сравнению с первоначальным проектом.

## Запуск
```
git clone https://github.com/Mi-ch-ael/spring-web-project-library.git
cd spring-web-project-library
mvn install
mvn spring-boot:run
```

Приложение запустится на [http://localhost:18080](http://localhost:18080).

## TODO
* Передавать идентификатор книги как параметр запроса;
* Хранить информацию о брони книги как отдельную сущность в БД;
* Хранить дату возвращения книги с использованием класса даты.

## Скриншоты
Главная страница
![Screenshot from 2022-05-28 15-53-39](https://user-images.githubusercontent.com/54897530/170829311-77a45c83-4ff8-4d99-b3b1-75f51bad5d9e.png)

Страница книги
![Screenshot from 2022-05-28 15-55-06](https://user-images.githubusercontent.com/54897530/170829335-f9bb220f-2c60-48ed-8d7a-c63f8a1783e1.png)

Информация о брони книги
![Screenshot from 2022-05-28 15-55-55](https://user-images.githubusercontent.com/54897530/170829642-39430f62-095a-436d-9a8f-ac06afc87030.png)

Сортировка по свободным книгам
![Screenshot from 2022-05-28 15-56-56](https://user-images.githubusercontent.com/54897530/170829415-034d1495-5f7c-4f28-8cfe-d32e83169fa6.png)

Сотртировка по книгам с просроченной датой сдачи
![Screenshot from 2022-05-28 15-57-50](https://user-images.githubusercontent.com/54897530/170829421-0f838f38-51fd-4386-a965-02c032485c10.png)
