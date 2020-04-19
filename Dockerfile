FROM openjdk:8-jdk-alpine
EXPOSE 8080
ARG JAR_FILE=target/spring-boot-with-Dockerfile-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} spring-boot-with-Dockerfile-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/app.jar"]
