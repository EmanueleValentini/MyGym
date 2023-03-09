FROM eclipse-temurin:17-jdk-jammy

WORKDIR /app
COPY .mvn/ .mvn
COPY mvnw pom.xml ./
COPY target/mygym-0.0.1-SNAPSHOT.jar mygym.jar
EXPOSE 8080
RUN ./mvnw dependency:resolve