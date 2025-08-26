# CityManagment (Spring Boot)

Небольшой учебный REST-сервис для управления сущностями «города»:
жители (`Person`), их автомобили (`Car`), дома (`House`) и паспорта (`Passport`).

- `Person` — ⟶ `Car`: **one-to-many**
- `Person` — ⟶ `Passport`: **one-to-one**
- `Person` — ⟷ `House`: **many-to-many** через таблицу `ref_person_house`

## Стек

- Java 17, Maven
- Spring Boot (Web, Data JPA)
- Lombok, MapStruct (для маппинга DTO)
- Liquibase для миграций БД

## Быстрый старт

### 1) Требования
- JDK 17+
- Maven 3.9+
- Любая реляционная БД (удобнее Postgres/H2 — см. `application.yml`)

### 2) Настройка `application.yml` (пример для Postgres)

```yaml
server:
  port: 8080

spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/city
    username: postgres
    password: postgres
  jpa:
    hibernate:
      ddl-auto: none  # миграции делает Liquibase
    show-sql: true
  liquibase:
    change-log: classpath:db/changelog/db.changelog-master.yaml
