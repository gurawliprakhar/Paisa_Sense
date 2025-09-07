# Use OpenJDK 17
FROM openjdk:17-jdk-alpine

WORKDIR /app

# Copy jar
COPY target/sms-service-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8090

# Directly run the app
CMD ["java", "-jar", "app.jar"]
