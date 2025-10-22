# FROM openjdk:11
FROM openjdk/openjdk11:alpine-jre
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]