# Приложение «Мобильный хоспис»


- [Цели проекта](#title1)
- [Описание приложения](#title2)
- [Процедура запуска авто-тестов](#title3)

---

## <a id="title1">Цели проекта</a>


1. Провести ручное тестирование мобильного приложения «Мобильный хоспис».
2. Составить чек-лист для проверки приложения.
3. Расписать тест-кейсы для проверки приложения.
4. Автоматизировать проверку тест-кейсов по чек-листу.
5. Составить отчёты о тестировании.

## <a id="title2">Описание приложения</a>
Приложение даёт функционал по работе с претензиями хосписа и включает в себя:

- информацию о претензиях и функционал для работы с ними;
- новостную сводку хосписа;
- тематические цитаты.

  ![image](https://github.com/STALKSA/QADiplom/assets/109988277/60b4b787-959d-43b0-981f-7bd60a0e4e26)

## <a id="title3">Процедура запуска авто-тестов:</a>

**1.** Склонировать на локальный репозиторий Дипломный проект

**2.** Запустить Android Studio

**3.** Запустить приложение(ввести логин:login2, пароль:password2)

**4.** В терминале перейти в корневую директорию проекта и выполнить команду для запуска всех авто-тестов:

```
 ./gradlew clean connectedAndroidTest
```

**6.** Сохрание отчета Allure на основе результатов выполненных тестов в директорию

    build/reports/allure-report

**5.** Открыть отчет в браузере:

    ./gradlew allureServe

После выполнения команды, вы увидите ссылку, по которой можно открыть отчет в браузере.


## Результаты запуска авто-тестов
[чек-лиcты, тест-кейсы, репорт по авто-тестам](https://github.com/STALKSA/HospiceAppProject/tree/main/docs)






