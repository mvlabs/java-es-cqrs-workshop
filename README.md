# Event sourcing/CQRS workshop, Java version

Source code for es/cqrs workshop built as **Spring Boot** web service.

## Installation pre-requirements

- Java 8
- Maven
- Docker (Compose)

## How to run the WS

* `mvn clean install -DskipTests`
* `mvn docker:build`
* `docker-compose up postgres` (this will create and initialize the db container, you can stop the container after it has been initialized)
* `docker-compose up`

Once all containers are running you can access the WS by visiting [http://localhost:8080/](http://localhost:8080/).

The Docker Compose script provides also a PGADMIN client. It is accessable from [http://localhost:5050](http://localhost:5050).
