# 3.2.Deadline
Тестирование функции входа в приложение с использованием базы данных mysql.

## Начало работы

Клонировать репозиторий 3.2.Deadline (https://github.com/InnaSmir/3.2.Deadline) и запустить проект в Intellij IDE.

## Установка и запуск

* Запустить контейнер в командной строке с помощью команды - `doker-compose up`
* Запустить приложение в командной строке app-deadline.jar с помощью команды `java -jar ./artifacts/app-deadline.jar -P:jdbc.url=jdbc:mysql://localhost:3306/app -P:jdbc.user=app -P:jdbc.password=pass`
* Запустить автотесты 
* При повторном запуске тестов, необходимо перезапустить приложение app-deadline.jar

P.S. Проблема с перезапуском SUT решена с помощью метода

```
  @AfterAll
    static void cleanTables() {

        DataSql.cleanData();
    }
    
  
