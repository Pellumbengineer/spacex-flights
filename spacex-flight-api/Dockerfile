FROM openjdk:11
LABEL maintainer="Pellumb Baboci"

ADD target/spacex-flight-api-0.0.1-SNAPSHOT.jar spacex-flight-api-v1.jar
ENTRYPOINT ["java -Dserver.port=$PORT","-jar","spacex-flight-api-v1.jar"]