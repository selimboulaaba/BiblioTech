FROM openjdk:17
EXPOSE 8089
ADD target/Order-0.0.1.jar Order-0.0.1.jar

ENTRYPOINT ["java","-jar","Order-0.0.1.jar"]