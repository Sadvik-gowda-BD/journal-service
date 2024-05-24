FROM openjdk:17-jdk-alpine
LABEL authors="sadvik gowda"

EXPOSE 8091

COPY target/journal-service-0.0.1.jar journal-service-0.0.1.jar
ENTRYPOINT ["java","-Dspring.profiles.active=prod","-jar","/journal-service-0.0.1.jar"]
