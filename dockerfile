
FROM maven:3.8.4-openjdk-21-slim as build

WORKDIR /app


COPY pom.xml .
RUN mvn dependency:go-offline


COPY src ./src
RUN mvn clean package -DskipTests


FROM openjdk:21-jdk-slim

WORKDIR /app


COPY --from=build /app/target/webclient-0.0.1-SNAPSHOT.jar /app/webclient-0.0.1-SNAPSHOT.jar


EXPOSE 8080


CMD ["java", "-jar", "webclient-0.0.1-SNAPSHOT.jar"]
