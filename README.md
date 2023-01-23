# СКБ vue.js + spring boot + postgresql

### Для запуска необходимо выполнить следующие команды:
- cd backend
  - смена текущего каталога на /backend
- mvn clean install -DskipTests=true
  - соберёт jar файл для backend модуля
- cd ..
  - вернёт в родительскую директорию
- docker-compose build:
  - Создаст образы на основе Dockerfile, лежащих в /backend и /frontend
- docker-compose up:
  - скачает образ postgres:latest с докерхаба, запустит контейнер
  - создаст и запустит контейнер для бэкенда
  - создаст и запустит контейнер для фронтенда

### Для авторизации доступны пользователи:
- Работник (username: Vasya, password: vasya123)
- Менеджер (username: Masha, password: masha123)