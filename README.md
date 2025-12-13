# Представление проекта:
```
com.omsu.gorch825
|
├── controller/ # REST контроллеры (Слой API)
|
├── service/ # Бизнес-логика (Слой Application)
|
├── repository/ # Работа с данными (Слой DataAccess / Domain)
|
├── model/ # Сущности (Слой Domain - Ядро)
|
├── dto/ # Request/Response классы (Слой API)
|
└── validation/ # Валидаторы (Слой Application)
```
- Ядро (model, repository): Правила и данные.
- Логика (validation, service): Обработка и проверка.
- Интерфейс (controller, dto): Взаимодействие с внешним миром.
