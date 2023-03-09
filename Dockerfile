FROM eclipse-temurin:17-jdk-jammy
WORKDIR /app
COPY target/mygym-0.0.1-SNAPSHOT ./target
EXPOSE 8080
ENTRYPOINT ["java","-jar","/target/mygym-0.0.1-SNAPSHOT.jar"]