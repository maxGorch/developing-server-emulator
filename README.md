# Представление проекта:
```
com.omsu.gorch825
|
├── controller/ # REST контроллеры 
|
├── service/ # Бизнес-логика 
|
├── repository/ # Работа с данными 
|
├── model/ # Сущности 
|
├── dto/ # Request/Response классы 
|
└── validation/ # Валидаторы
```
- Ядро (model, repository): Правила и данные.
- Логика (validation, service): Обработка и проверка.
- Интерфейс (controller, dto): Взаимодействие с внешним миром.
