FROM openjdk:21-jdk-slim
VOLUME /tmp
ARG JAR_FILE=target/inventario-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
