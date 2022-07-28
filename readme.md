# SalesTray Backend

This is a BackEnd **Nodejs** server which provide API support using REST API for the web based frontend.

## Why Not Spring-boot?

1. App doesn't ean to handle high load
2. Concurrent transactions are not required
3. Nodejs has relatively low CPU utilization because it handles requests using asynchronous functions.

## Deployment

Deployment uses a Dockerfile which ease the management of the dependencies and run time configurations.

To start the app just execute the following command.

`docker-compose up`

### Technologies Used

1. Nodejs 16
2. MySql 5.7
3. ExpressJs
4. JasonWebToken

## License

MIT

### Resources referred

1. [Docker overview](https://docs.docker.com/get-started/overview/)
2. [Dockerize Node.js Express and MySQL example – Docker Compose](https://www.bezkoder.com/docker-compose-nodejs-mysql/).

