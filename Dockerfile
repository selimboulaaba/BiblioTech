FROM openjdk:17
EXPOSE 8761
ADD target/server-bibliotech-docker.jar server-bibliotech-docker.jar
ENTRYPOINT ["java", "-jar", "server-bibliotech-docker.jar"]