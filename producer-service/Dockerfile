FROM openjdk:19-jdk-alpine

WORKDIR /app

COPY ./target/producer-service-0.0.1-SNAPSHOT.jar /app/

EXPOSE 8082

ENTRYPOINT ["java","-jar","producer-service-0.0.1-SNAPSHOT.jar"]