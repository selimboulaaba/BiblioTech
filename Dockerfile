FROM openjdk:17
EXPOSE 8081
ADD target/BiblioTechAPIGateway-0.0.1-SNAPSHOT.jar BiblioTechAPIGateway-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "BiblioTechAPIGateway-0.0.1-SNAPSHOT.jar"]
