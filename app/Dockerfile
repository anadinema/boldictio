FROM maven:3.8.2-openjdk-17-slim AS build
COPY app/src /docker/application/src
COPY app/pom.xml /docker/application
RUN mvn -f /docker/application/pom.xml clean package spring-boot:repackage

FROM eclipse-temurin:17
COPY --from=build /docker/application/target/*.jar /docker/boldictio-backend-service.jar
EXPOSE 8081
ENTRYPOINT ["java","-jar","/docker/boldictio-backend-service.jar"]