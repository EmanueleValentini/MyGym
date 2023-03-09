FROM eclipse-temurin:17-jdk-jammy
WORKDIR /app
COPY target/mygym-0.0.1-SNAPSHOT .source
EXPOSE 8080
CMD ["java","-jar","source/mygym-0.0.1-SNAPSHOT.jar"]