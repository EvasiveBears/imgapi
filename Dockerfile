FROM openjdk:11-jdk
VOLUME /kitty
ARG JAR_FILE=./*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]