FROM openjdk:19-jdk-alpine

WORKDIR /app

COPY ./target/kafka-broker-service-0.0.1-SNAPSHOT.jar /app/

EXPOSE 8081


ENTRYPOINT ["java","-jar","kafka-broker-service-0.0.1-SNAPSHOT.jar"]