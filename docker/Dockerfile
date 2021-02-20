FROM openjdk:11-slim

RUN mkdir /opt/app

COPY target/*.jar /opt/app/app.jar

CMD ["java", "-jar", "-Dspring.profiles.active=${PROFILE}", "/opt/app/app.jar"]