# SalesTray Backend

This is a BackEnd using a **Spring-Boot** server which provide API support using REST API for the web based frontend.

## Why Spring-boot?

1. Nodejs is good option but Liquibase requires JRE for the DB versioning
2. No point of maintaining two separate run times on the same server
3. Additionally, I like the Spring-security layer and also the annotation support

## Features

1. Validate all requests based on JSON Web Token
2. Customized Exception handling

## Deployment

Deployment uses a Dockerfile which ease the management of the dependencies and run time configurations.

To start the app just execute the following command.

`docker-compose up`

### Technologies Used

1. Spring-boot 2.7.0
2. MySql 5.7
3. JasonWebToken
4. [Lombok](https://www.baeldung.com/intro-to-project-lombok)

## License

MIT

### Resources referred

1. [Docker overview](https://docs.docker.com/get-started/overview/)
2. [Dockerizing a Spring Boot Application](https://www.baeldung.com/dockerizing-spring-boot-application)

