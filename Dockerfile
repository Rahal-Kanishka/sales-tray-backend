FROM openjdk:8-jdk-alpine
MAINTAINER Rahal Danthanarayana
COPY target/sales-tray-backend-0.0.1-SNAPSHOT.jar sales-tray-backend-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/sales-tray-backend-0.0.1-SNAPSHOT.jar"]