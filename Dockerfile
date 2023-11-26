FROM openjdk:17
EXPOSE 8089
ADD target/review-bibliotech-docker.jar review-bibliotech-docker.jar
ENTRYPOINT ["java", "-jar", "review-bibliotech-docker.jar"]