FROM openjdk:17
EXPOSE 8087
ADD target/bookMicroService-0.0.1-SNAPSHOT.jar bookMicroService-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "bookMicroService-0.0.1-SNAPSHOT.jar"]
