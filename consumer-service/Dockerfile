FROM openjdk:19-jdk-alpine

WORKDIR /app

COPY ./target/consumer-service-0.0.1-SNAPSHOT.jar /app/

EXPOSE 8083

ENTRYPOINT ["java","-jar","consumer-service-0.0.1-SNAPSHOT.jar"]